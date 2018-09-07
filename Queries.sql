
--Give me Second Highest salary from all the employee
select  e.empname as employeeName, max(s.salary) as employeeSalary from employee e 
 inner join salary s on e.empid = s.empid 
    where s.salary not in (select max(salary) from salary)
	group by e.empname 
	   order by employeeSalary desc limit 1;


--Give me second last lowest salary from all the employee
select  e.empname as employeeName, min(s.salary) as employeeSalary from employee e 
 inner join salary s on e.empid = s.empid 
    where s.salary not in (select min(salary) from salary)
	group by e.empname 
	   order by employeeSalary limit 1;


--Give me average salary of a each Department
select d.deptname as department, avg(t.salary) as avgsalary 
from department d inner join 
     (select * from employee 
        inner join salary s on employee.empid = s.empid) t 
on t.deptid = d.deptid 
group by department;


--Give me output in format as below
----Employee Id, Emp Name, Dept Name, Salary

--Give me employees which doesn’t belong to any Department 
select e.empid as EmployeeId, e.empname as EmpName, d.deptname as DeptName, s.salary as Salary 
from employee e 
left join department d 
on e.deptid = d.deptid 
left join salary s 
on s.empid = e.empid 
where deptname is null;


--Give me employees which doesn’t have manager
--Assumption if mngempid = empid then it cannot be his/her own manager so 
--result is just checking this condition
select empname as name from employee where empid=managerempid OR empid is null;