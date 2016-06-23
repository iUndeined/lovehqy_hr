findSchedulingByDate
===
-- 还需要增加是否已经考勤的判断
select 
	i.id 
,	i.work_man 
,	i.work_man_name 

from t_work_scheduling as i where i.work_date = ? 