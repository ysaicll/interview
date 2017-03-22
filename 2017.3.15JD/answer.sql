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
WHERE (Date_<'2013-12-31' AND Date_>'2013-1-1') UNION
SELECT COUNT(Order_ID) sum_order,SUM(Amount*Price ) sum_cus FROM Sales 
WHERE (Date_<'2014-12-31' AND Date_>'2014-1-1') UNION
SELECT COUNT(Order_ID) sum_order,SUM(Amount*Price ) sum_cus FROM Sales 
WHERE (Date_<'2015-12-31' AND Date_>'2015-1-1');

/*建立一张新表格，提取amount超过500的订单，并添加一列“Level”。“Level”定义为，
amount超过1000的称为“高端”，amount介于500和1000的称为“中高端”。*/
select * ,
(case when amount>500 and amount<=1000 then '中高端' 
 case when amount>1000 then '高端' end from sales) Level_
 from sales;

/*找出名称里带括号的品牌名*/
select brandname from sales
where brandname like '%（%';

/*统计2016 年各月累计销售总额。
（返回2016 年各月份和累计销售额两列，按月份排序）*/
select month(Date_) yuefen ,SUM(Amount*Price ) profit from sales
where year(Date_)
group by month(Date_);

/*统计2016 年“双十一”当日各品牌销售额最高的sku，
返回品牌名，sku 名和销售总额。*/
select brandname,sku,SUM(Amount*Price ) profit FROM sales
where Date_='2016-11-11'
group by sku
order by profit desc
limit 1;

/*统计一、二、三、四线城市的2013年至2016年的各年销售总额，按时间顺序排列，并
将上述结果建立成如表格4 的报表形式。*/

