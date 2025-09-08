class Solution {
public:
    vector<int> getNoZeroIntegers(int n) {
        for (int i = 1; i <= n; i++) {
            int a = i;
            int b = n - i;
            if (!isZero(a) && !isZero(b)) {
                return {a, b};
            }
        }
        return {-1, -1};
    }

    bool isZero(int n) {
        while (n > 0) {
            if (n % 10 == 0) 
                return true;
            n /= 10;
        }
        return false;
    }
};