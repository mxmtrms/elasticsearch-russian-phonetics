set terminal pngcairo enhanced nocrop font "Verdana,10" fontscale 1.0 size 800, 600
set output 'it_surnames.png'

load 'it.pal'

set title "Encoding throughput by iteration, ops/sec (Russian names)" font ",14"
set tmargin 5
set bmargin 5

set grid
set border 3 back lc rgb '#636363' lt 1
set tics nomirror
set style data linespoints

set xrange [-0.5:49]
set yrange [0:4000000]

set ytics ("" 0, "500K" 500000, "1M" 1000000, "1.5M" 1500000, "2M" 2000000, "2.5M" 2500000,"3M" 3000000,"3.5M" 3500000,"4M" 4000000)

set for [i=1:4] arrow from (i)*10 - 0.5,0 to (i)*10- 0.5,4000000 lt 2 lc rgb "#969696" nohead

set key outside bottom center horizontal font "Verdana,10"

getXLabel(i) = i == 1 || i < 50 && (int(i) - 1) % 10 == 0 ? sprintf("Fork %d", (int(i) / 10) + 1) : ""

plot for [i=2:10] 'it_surnames.dat' using i:xticlabel(getXLabel($1)) ls (i-1) title columnheader(i)
