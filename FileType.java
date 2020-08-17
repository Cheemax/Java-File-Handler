package work1;

public enum FileType{
        ASTA("asta"), JPG("jpg"), HTML("html"), TEXT("txt");
        private String type;
        FileType(String type){
            this.type = type;
        }

        public String getType(){
            return type;
        }
}