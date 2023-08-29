import xlsxwriter

workbook = xlsxwriter.Workbook('Deals.xlsx')
worksheet = workbook.add_worksheet()

file = open("middleman.txt", "r", encoding="utf-8")
lines = file.read().split("\n")
priceList = []
productList = []
for line in lines:
	if len(line) > 0:
		if line[0] == "$":
			priceList.append(line)
		else:
			productList.append(line)

loopy = 0
row = 1
col = 0
worksheet.write(0, 0, "Product")
worksheet.write(0, 10, "Price")
while loopy < len(productList):
	worksheet.write(row, col, productList[loopy])
	worksheet.write(row, col+10, priceList[loopy])
	row += 1
	loopy += 1

workbook.close()