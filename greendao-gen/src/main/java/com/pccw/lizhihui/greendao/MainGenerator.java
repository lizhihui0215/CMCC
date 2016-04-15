package com.pccw.lizhihui.greendao;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class MainGenerator {
    private static final String PROJECT_DIR = System.getProperty("user.dir");

    public static void main(String[] args) throws Exception{
        Schema schema = new Schema(1000,"com.pccw.lizhihui.cmcc.data.greendao.gen");
        MainGenerator.addTables(schema);

        DaoGenerator daoGenerator =  new DaoGenerator();

        daoGenerator.generateAll(schema, PROJECT_DIR + "/data/src/main/java");

    }

    private static void addTables(final Schema schema){
        Entity user = addUser(schema);

        Entity department = addDepartment(schema);

        Property departmentId = department.addLongProperty("departmentId").notNull().getProperty();

        department.addToOne(user,departmentId,"user");

        user.addToMany(department, departmentId, "deptList");
    }

    private static Entity addDepartment(final Schema schema){
        Entity department = schema.addEntity("DepartmentEntity");
        department.addIdProperty();
        department.addStringProperty("deptName");
        department.addStringProperty("deptCode");
        department.addStringProperty("parentCode");
        department.addStringProperty("deptId");
        return department;
    }

    private static Entity addUser(Schema schema) {
        Entity user = schema.addEntity("UserEntity");
        user.addIdProperty().primaryKey().autoincrement();
        user.addStringProperty("phone");
        user.addStringProperty("accessToken");
        user.addStringProperty("token");
        user.addStringProperty("userId");
        user.addStringProperty("userName");
        user.addStringProperty("account");

        return user;
    }

}
