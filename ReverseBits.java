// Reverse the bits of an 32 bit unsigned integer A.
// 0 <= A <= 2^32

class ReverseBits {
    public long reverse(long a) {
        long result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            if (isCurrentBitSet(a, i)) {
                result = result | 1; //set the last bit in result
            }
        }
        return result;
    }

    private boolean isCurrentBitSet(long a, int i) {
        return (a & (1 << i)) > 0;
    }
}
