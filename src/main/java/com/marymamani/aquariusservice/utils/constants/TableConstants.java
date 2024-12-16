package com.marymamani.aquariusservice.utils.constants;

public class TableConstants {

    public static class AreaTable {
        public static final String TABLE_NAME = "areas";
        public static final String CODE = "codigo";
        public static final String NAME = "nombre";

    }

    public static class EmployeeTable {
        public static final String TABLE_NAME = "empleados";
        public static final String CODE = "codigo";
        public static final String NAME = "nombre";
        public static final String AREA = "codigo_area";
        public static final String EMAIL = "correo";
        public static final String PHONE_NUMBER = "celular";
        public static final String FOREIGN_KEY = "fk_empleado_area";

    }
}
