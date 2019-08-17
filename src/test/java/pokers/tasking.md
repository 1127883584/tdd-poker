##### 只比较第一个牌的大小
### should_return_player1_win_when_player1_is_2H_3C_7H_8S_9H_and_player2_is_3H_5C_6H_7S_8H
`
（2H_3C_7H_8S_9H） ，（3H_5C_6H_7S_8H）
（1 player win）
`

##### 第一个牌的大小相同，比较第二个牌大小
### should_return_player2_win_when_player1_is_2H_3C_6H_7S_9H_and_player2_is_3H_4D_5C_8S_9D
`
（2H_3C_6H_7S_9H） ，（3H_4D_5C_8S_9D）
（2 player win）
`

##### 牌中有特殊编码的牌(T,J,Q,K,A)
### should_return_player1_win_when_player1_is_2H_3C_6H_7S_KH_and_player2_is_3H_4D_5C_8S_TD
`
（2H_3C_6H_7S_KH） ，（3H_4D_5C_8S_TD）
（1 player win）
`

##### player1 和 player2 牌一样
### should_return_null_when_player1_is_2H_5C_7H_8S_AH_and_player2_is_2D_5D_7C_8C_AD
`
（2H_5C_7H_8S_AH） ，（2D_5D_7C_8C_AD）
（null）
`

##### player1有对子，player2没有对子
### should_return_player1_win_when_player1_is_2H_2C_7H_8S_TH_and_player2_is_2D_5D_7C_8C_AD
`
（2H_2C_7H_8S_TH） ，（2D_5D_7C_8C_AD）
（1 player win）
`

##### player1有对子，player2有对子
### should_return_player2_win_when_player1_is_2H_2C_7H_8S_AH_and_player2_is_5D_5C_7C_8C_TD
`
（2H_2C_7H_8S_AH） ，（5D_5C_7C_8C_TD）
（2 player win）
`

##### player1 跟 player2有同样的对子， 比单个最大的牌
### should_return_player1_win_when_player1_is_5H_5S_7H_8S_AH_and_player2_is_5D_5C_7C_8C_TD
`
（5H_5S_7H_8S_AH） ，（5D_5C_7C_8C_TD）
（1 player win）
`

##### player1 跟 player2有同样的对子， 比单个最大的牌
### should_return_player1_win_when_player1_is_5H_5S_7H_8S_AH_and_player2_is_5D_5C_7C_8C_TD
`
（5H_5S_7H_8S_AH） ，（5D_5C_7C_8C_TD）
（1 player win）
`

##### player1 只有1个比较大的对子，player2有两个对子
### should_return_player2_win_when_player1_is_9H_9C_7H_8S_AH_and_player2_is_7C_7S_5D_5C_TD
`
（9H_9C_7H_8S_AH） ，（7C_7S_5D_5C_TD）
（2 player win）
`
