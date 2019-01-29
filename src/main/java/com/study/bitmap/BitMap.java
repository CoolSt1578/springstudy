package com.study.bitmap;

/**
 * https://www.cnblogs.com/zhuoqingsen/p/9214709.html
 * 学习位图算法
 * 数据库做持久化的时候，把数据做成数字模型这种形式来存储（比如只存用户ID），若有数据就标志为1或true，若无数据标志为0或false

 * 比如有一数字模型{5，2，1，2} 这里最大值为5，所以数组的长度就是5，而0到5中不存0，3，4数字

 * 所以：Array[0]=0，Array[1]=1，Array[2]=2，Array[3]=0，Array[4]=0，Array[5]=1

 * 数组模型如下 ：int[] ={0,1,2,0,0,1}

 * 上面数中由于2有两个，所以只能用int存数组的值，不用boolean型，这样如果有多个同样的数字可以用值表示个数。如上面Array[2]=2，就表示2有2个
 * Created by guo on 2019/1/28.
 */
public class BitMap {


	/*
		1.判断一个数是否存在某数据中，假如有40亿数据，我们如何快速判断指定一个数是否存在？
		申请512M的内存 512M=512*1024*1024B*8=4294967296比特(bit)  这个空间可以装40亿了
		一个bit位代表一个int值
		读入40亿个数，设置相应的bit位
		读入要查询的数，查看相应bit位是否为1，为1表示存在，为0表示不存在

		https://blog.csdn.net/v123411739/article/details/86652806
		由于Java中无法直接操作二进制数，因此我们可以通过 int 来实现。1个二进制数占用1 Bit；1个 int 占用4 Byte，也就是32 Bit。
		因此，我们可以使用1个int来表示32个二进制数。
		所以，我们有以下思路：
		第1个int表示：整数0 ~ 31是否存在，
		第2个int表示：整数32 ~ 63是否存在，
		第3个int表示：整数64 ~ 95是否存在，依此类推。
		因此，我们最终可以使用一个int数组来表示4294967296个二进制数，通过数组的下标来指示第几个int。
	 */
	static class Bitmap {
		/**
		 * 位图提供的最大长度,
		 * 比如unsigned int的最大值为4294967295, 则需要的length为4294967296
		 */
		private long length;

		/**
		 * 位图桶
		 */
		private static int[] bitmapBucket;

		/**
		 * int用来表示32位二进制数,
		 * BIT_VALUE[0]表示第1个二进制数存在、
		 * BIT_VALUE[1]表示第2个二进制数存在，以此类推
		 *
		 * BIT_VALUE[0] = 00000000 00000000 00000000 00000001
		 * BIT_VALUE[1] = 00000000 00000000 00000000 00000010
		 * BIT_VALUE[2] = 00000000 00000000 00000000 00000100
		 * ...
		 * BIT_VALUE[31] = 10000000 00000000 00000000 00000000
		 */
		private static final int[] BIT_VALUE = {
				0x00000001, 0x00000002, 0x00000004, 0x00000008,
				0x00000010, 0x00000020, 0x00000040, 0x00000080,
				0x00000100, 0x00000200, 0x00000400, 0x00000800,
				0x00001000, 0x00002000, 0x00004000, 0x00008000,
				0x00010000, 0x00020000, 0x00040000, 0x00080000,
				0x00100000, 0x00200000, 0x00400000, 0x00800000,
				0x01000000, 0x02000000, 0x04000000, 0x08000000,
				0x10000000, 0x20000000, 0x40000000, 0x80000000};

		/**
		 * length为1 - 32: 需要1个桶
		 * length为33 - 64: 需要2个桶
		 * ...
		 * 以此类推
		 *
		 * @param length
		 */
		public Bitmap(long length) {
			this.length = length;
			// 根据长度算出，所需位图桶个数
			bitmapBucket = new int[(int) (length >> 5) + ((length & 31) > 0 ? 1 : 0)];
		}

		/**
		 * 查找number是否存在于位图桶中
		 *
		 * @param number 要查询的数字
		 * @return true: number在位图桶中, false: number不在位图桶中
		 */
		public boolean getBit(long number) {
			if (number < 0 || number > length) {
				throw new IllegalArgumentException("非法参数");
			}
			// 计算该number在哪个桶
			int belowIndex = (int) (number >> 5);
			// 求出该number在桶里的下标,（求出该值在32位中的哪一位, 下标0 - 31）
			int offset = (int) (number & 31);
			// 拿到该桶的值
			int currentValue = bitmapBucket[belowIndex];
			// 计算该number是否存在
			return ((currentValue & BIT_VALUE[offset])) == 0 ? false : true;
		}

		/**
		 * 将number在位图桶中标记为存在
		 *
		 * @param number 要标记的数字
		 */
		public void setBit(long number) {
			// 合法性校验
			if (number < 0 || number >= length) {
				throw new IllegalArgumentException("非法参数");
			}
			// 计算该number在哪个桶
			int belowIndex = (int) (number >> 5);
			// 求出该number在桶里的下标,（求出该值在32位中的哪一位, 下标0 - 31）
			int offset = (int) (number & 31);
			// 拿到该桶的当前值
			int currentValue = bitmapBucket[belowIndex];
			// 将number在桶里标记
			bitmapBucket[belowIndex] = currentValue | BIT_VALUE[offset];
		}
	}

	public static void main(String[] args) {
		Bitmap bitMap = new Bitmap(11);
		bitMap.setBit(8);
		System.out.println(bitMap.getBit(8));
		System.out.println(bitMap.getBit(6L));

		for(int i : Bitmap.BIT_VALUE){
			System.out.println(i);
		}
	}


}
