package constants;

public class Constants {

    public static class ServerBaseUrlName {
        public static String BASE_URL = "https://reqres.in/api/";
    }

    public static class FieldsInResponse {
        public static final String ID = "id";
        public static final String JOB = "job";
        public static final String NAME = "name";
        public static final String CREATED_AT = "createdAt";
        public static final String UPDATE_AT = "updatedAt";
        public static final String ERROR = "error";
        public static final String TOKEN = "token";
        public static final String EMAIL = "email";
        public static final String PASSWORD = "password";
    }

    public static class ErrorsInResponse {
        public static final String error_400_Missing_password = "Missing password";
        public static final String error_400_auth = "user not found";

    }

    public static class Path {
        public static final String credPath = "./src/test/resources/login_data.txt";
        public static final String credPathInc = "./src/test/resources/login_data_inc.txt";

    }


}
