package application;

public class Field {
   private String name;
   private String allowedValue;
   private String mandatory;
   private String inOut;
   
   public String getName() {
       return name;
   }
   
   public String getAllowedValue() {
       return allowedValue;
   }

   public String getMandatory() {
       return mandatory;
   }

   public void setName(String name) {
       this.name = name;
   }

   public void setAllowedValue(String allowedValue) {
       this.allowedValue = allowedValue;
   }

   public void setMandatory(String mandatory) {
       this.mandatory = mandatory;
   }

   public String getInOut() {
       return inOut;
   }

   public void setInOut(String inOut) {
       this.inOut = inOut;
   }
}
