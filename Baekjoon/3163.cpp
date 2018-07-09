#include <iostream>
#include <vector>
#include <algorithm>
#include <deque>
 
typedef std::vector<std::pair<int, int>> vp;
 
vp ant;
std::deque<int> idList;
std::vector<int> fallList;
 
int main(void){
    int tc; std::cin >> tc;
    while (tc--) {
        int n, l, k, id, pos; std::cin >> n >> l >> k;
        while (n--) {
            std::cin >> pos >> id;
            idList.push_back(id);
            id < 0 ? ant.push_back({ pos,id }) : ant.push_back({ l - pos,id });
        }
        std::sort(ant.begin(), ant.end());
 
        for (int i = 0; i < ant.size(); i++) {
            int frontValue = idList.front(), backValue = idList.back();
 
            if (i != ant.size() - 1 && ant[i].first == ant[i + 1].first) {
                if (frontValue < backValue) {
                    fallList.push_back(frontValue);
                    fallList.push_back(backValue);
                }
                else {
                    fallList.push_back(backValue);
                    fallList.push_back(frontValue);
                }
                idList.pop_back(); idList.pop_front(); i++;
            }
            else if (ant[i].second < 0) {
                fallList.push_back(frontValue);
                idList.pop_front();
            }
            else {
                fallList.push_back(backValue);
                idList.pop_back();
            }
        }
        std::cout << fallList[k - 1] << '\n';

        ant.clear();
        idList.clear();
        fallList.clear();
    }
    return 0;
}
