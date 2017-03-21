/*User ID 为“D69A5”的用户在2016 年上半年买品牌是“美的”的所有订单号和SKU名字。
（仅返回订单号和sku 名字两列）*/
SELECT Order_ID,SKU FROM Sales WHERE
(User_ID='D69A5'AND Brandname='美的'AND 
Date_>'2016-1-1'AND Date_<'2016-6-30');

/*2015 年销售总额前50的品牌及其销售额，结果按销售总额从高到低排序。
（返回品牌和销售额两列*/
SELECT Brandname, Amount*Price AS sale_sum FROM Sales
WHERE Date_<'2015-12-31' AND Date_>'2015-1-1'
ORDER BY sale_sum DESC
LIMIT 50;

/*统计2013、2014和2015年各年的总订单数和总消费额。*/
SELECT COUNT(Order_ID) sum_order,SUM(Amount*Price ) sum_cus FROM Sales 
WHERE Date_<'2013-12-31' AND Date_>'2013-1-1');
