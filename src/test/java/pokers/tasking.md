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

##### 牌中有特殊编码的牌(T,J,Q,K,A)
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

