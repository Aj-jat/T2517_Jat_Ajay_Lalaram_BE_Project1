# T2517_Jat_Ajay_Lalaram_BE_Project1

The project contains two entitites i.e the Employee and the Department and the relationship between Employee and Department is ManyToOne(Department has many Employees in it). The project deals with the CRUD operations on both the entities.

![Screenshot 2022-02-08 at 6 59 15 AM](https://user-images.githubusercontent.com/58775348/152902563-c804c309-646a-4150-9e5e-b9219adf5cfb.png)

Adding a department

![Screenshot 2022-02-08 at 7 02 25 AM](https://user-images.githubusercontent.com/58775348/152902583-e0c6be7e-6c2b-4782-90b5-82745fe2c7c8.png)

Getting list of all added departments

![Screenshot 2022-02-08 at 7 01 15 AM](https://user-images.githubusercontent.com/58775348/152902567-3652da4d-33f4-4dd4-8416-6bc0f83c3ced.png)

Adding employee in a department

![Screenshot 2022-02-08 at 7 03 33 AM](https://user-images.githubusercontent.com/58775348/152902602-95908a50-9b4d-46ad-a7e5-d0c36f5744eb.png)

Getting list of all added employees.

![Screenshot 2022-02-08 at 7 09 40 AM](https://user-images.githubusercontent.com/58775348/152902684-39c8012a-1875-4cb5-a2e9-875e57251147.png)

Getting list of all the employees in a particular department with Query written in the EmployeeRepository.java

![Screenshot 2022-02-08 at 7 06 50 AM](https://user-images.githubusercontent.com/58775348/152902646-669a1406-05a5-449b-bf8d-056dd0062b79.png)

Updating employee

![Screenshot 2022-02-08 at 6 57 21 AM](https://user-images.githubusercontent.com/58775348/152902545-68431c74-c212-49b9-8677-c18faed20ad0.png)

Updating department

![Screenshot 2022-02-08 at 7 07 53 AM](https://user-images.githubusercontent.com/58775348/152903821-3d373cba-f8e2-4e7c-bf6a-ee4286862b16.png)


Deleting employee 


![Screenshot 2022-02-08 at 8 27 26 AM](https://user-images.githubusercontent.com/58775348/152909642-8e608f90-a807-4d9b-80c8-415501af8461.png)

Deleting department(Referential Integrity case) (Before deleting department we have to delete all the employees with that department as DepartmentId is a foreign Key in Employee table )
