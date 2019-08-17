### 1.只比较第一个牌的大小
##### should_return_player1_win_when_player1_is_2H_3C_7H_8S_9H_and_player2_is_3H_5C_6H_7S_8H
`
（2H_3C_7H_8S_9H） ，（3H_5C_6H_7S_8H）
（1 player win）
`

### 2.第一个牌的大小相同，比较第二个牌大小
##### should_return_player2_win_when_player1_is_2H_3C_6H_7S_9H_and_player2_is_3H_4D_5C_8S_9D
`
（2H_3C_6H_7S_9H） ，（3H_4D_5C_8S_9D）
（2 player win）
`

### 3.牌中有特殊编码的牌(T,J,Q,K,A)
##### should_return_player1_win_when_player1_is_2H_3C_6H_7S_KH_and_player2_is_3H_4D_5C_8S_TD
`
（2H_3C_6H_7S_KH） ，（3H_4D_5C_8S_TD）
（1 player win）
`

### 4.player1 和 player2 牌一样
##### should_return_null_when_player1_is_2H_5C_7H_8S_AH_and_player2_is_2D_5D_7C_8C_AD
`
（2H_5C_7H_8S_AH） ，（2D_5D_7C_8C_AD）
（null）
`

### 5.player1有对子，player2没有对子
##### should_return_player1_win_when_player1_is_2H_2C_7H_8S_TH_and_player2_is_2D_5D_7C_8C_AD
`
（2H_2C_7H_8S_TH） ，（2D_5D_7C_8C_AD）
（1 player win）
`

### 6.player1有对子，player2有对子
##### should_return_player2_win_when_player1_is_2H_2C_7H_8S_AH_and_player2_is_5D_5C_7C_8C_TD
`
（2H_2C_7H_8S_AH） ，（5D_5C_7C_8C_TD）
（2 player win）
`

### 7.player1 跟 player2有同样的对子， 比单个最大的牌
##### should_return_player1_win_when_player1_is_5H_5S_7H_8S_AH_and_player2_is_5D_5C_7C_8C_TD
`
（5H_5S_7H_8S_AH） ，（5D_5C_7C_8C_TD）
（1 player win）
`

### 8.player1 跟 player2有同样的对子， 比单个最大的牌
##### should_return_player1_win_when_player1_is_5H_5S_7H_8S_AH_and_player2_is_5D_5C_7C_8C_TD
`
（5H_5S_7H_8S_AH） ，（5D_5C_7C_8C_TD）
（1 player win）
`

### 9.player1 只有1个比较大的对子，player2有两个对子
##### should_return_player2_win_when_player1_is_9H_9C_7H_8S_AH_and_player2_is_7C_7S_5D_5C_TD
`
（9H_9C_7H_8S_AH） ，（7C_7S_5D_5C_TD）
（2 player win）
`

### 10.player1 有1个比较小和1个比较大的对子，player2有两个中等大小的对子
##### should_return_player1_win_when_player1_is_2H_2C_9H_9S_5H_and_player2_is_7C_7S_5D_5C_TD
`
（2H_2C_9H_9S_5H） ，（7C_7S_5D_5C_TD）
（1 player win）
`

### 11.player1 有两个对子，player2有3个相同的牌
##### should_return_player2_win_when_player1_is_2H_2C_9H_9S_AH_and_player2_is_7C_7S_7D_5C_TD
`
（2H_2C_9H_9S_AH） ，（7C_7S_7D_5C_TD）
（2 player win）
`

### 12.player1 有普通的顺子，player2有3个相同的牌
##### should_return_player1_win_when_player1_is_3H_4C_5H_6S_7H_and_player2_is_7C_7S_7D_5C_TD
`
（3H_4C_5H_6S_7H） ，（7C_7S_7D_5C_TD）
（1 player win）
`

### 13.player1 有普通的顺子，player2有普通的顺子
##### should_return_player2_win_when_player1_is_3H_4C_5H_6S_7H_and_player2_is_4C_5S_6D_7C_8D
`
（3H_4C_5H_6S_7H） ，（4C_5S_6D_7C_8D）
（2 player win）
`

### 14.player1 有同花，player2有普通的顺子
##### should_return_player1_win_when_player1_is_2H_3H_5H_6H_7H_and_player2_is_4C_5S_6D_7C_8D
`
（2H_3H_5H_6H_7H） ，（4C_5S_6D_7C_8D）
（1 player win）
`

### 15.player1 有同花，player2有同花
##### should_return_player2_win_when_player1_is_2H_3H_5H_6H_7H_and_player2_is_3S_5S_6S_7S_8S
`
（2H_3H_5H_6H_7H） ，（3S_5S_6S_7S_8S）
（2 player win）
`

### 16.player1 有俘虏，player2有同花
##### should_return_player1_win_when_player1_is_3H_3C_3D_6H_6C_and_player2_is_3S_5S_6S_7S_8S
`
（3H_3C_3D_6H_6C） ，（3S_5S_6S_7S_8S）
（1 player win）
`

### 17.player1 有俘虏，player2有俘虏
##### should_return_player2_win_when_player1_is_3H_3C_3D_6H_6C_and_player2_is_5C_5S_5D_4S_4D
`
（3H_3C_3D_6H_6C） ，（5C_5S_5D_4S_4D）
（2 player win）
`