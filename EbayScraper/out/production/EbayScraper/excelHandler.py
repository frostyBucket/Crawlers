file = open("middleman.txt", "r", encoding="utf-8")
lines = file.read().split("\n")
priceList = []
productList = []
for line in lines:
	print(line[0])