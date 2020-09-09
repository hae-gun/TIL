def draw_stars(depth, x, y):
    if depth ==1 :
        Map[y][x] = '*'
        return
    row = pow(2,depth+1) - 3
    col = pow(2,depth)- 1

    if depth % 2 == 0:
        for i in range(x,row+x):
            Map[y][i] = '*'
        for i in range(col):
            Map[y+i][x+i] = '*'
            Map[y+i][x+row-1-i] = '*'

        draw_stars(depth-1,pow(2,depth-1)+x,y+1)
    else:
        for i in range(x,row+x):
            Map[y+col-1][i] = '*'
        for i in range(col):
            Map[y+i][x+row//2-i]='*'
            Map[y+i][x+row//2+i]='*'
        draw_stars(depth-1,pow(2,depth-1)+x,y+col//2)


n= (int)(input())
row = pow(2,n+1)-3
col = pow(2,n)-1
Map = [[' ']*row for _ in range(col)]
draw_stars(n,0,0)

if n % 2 == 0:
    for i in range(col):
        for j in range(row-i):
            print(Map[i][j], end="")
        print()
else:
    for i in range(col):
        for j in range(row-col+i+1):
            print(Map[i][j], end="")
        print()
    
