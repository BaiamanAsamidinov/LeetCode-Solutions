class Solution {
public:
    vector<int> sumZero(int n) {
    vector<int> ourVec;           
        for(int i = 1; i <= n/2; ++i){
            ourVec.push_back(i);
            ourVec.push_back(-i);
        }
        if(n % 2 == 1){
            ourVec.push_back(0);
        }
        return ourVec;
    }
};