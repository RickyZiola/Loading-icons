
class Main {
  
  public static void main(String[] args) {
    Icon loading = new Icon();
    if(args.length>0){
      loading.setType(Integer.parseInt(args[0]));
    }else{
      loading.setType(2);
    }
    for(int i = 0; i < 100; i++){
       if(args.length>1){
          loading.update(i, 100, args[1]);
        }else{
         loading.update(i, 100, "\u001B[31mNO_TEXT_SPECIFIED\u001B[0m ");
        }
       try{
         Thread.sleep(100);
       }catch(InterruptedException ex){
         Thread.currentThread().interrupt();
       }
    }
    loading.setType(0);
    loading.update(100, 100, "");

  }
}
class Icon{
  static int i = 0;
  static boolean created = false;
  static String[] types = {"none", "spinner", "progressBar"};
  static int currentType = 0;
  public Icon(){
  }
  static void setType(int toSet){
    currentType = toSet;
  }
  static void update(double progress, double total, String text){
    created = true;
    if(currentType == 2){
      double modFactor = 30 / total;
      total = total * modFactor;
      progress = progress * modFactor;
      if(created){
        for(int i = 0; i < 32 + text.length() + String.valueOf(Math.floor(progress / total * 100)).length(); i++){
          System.out.print("\b");
        }
      }
     System.out.print("|");
     for(int i = 0; i < total; i++){
       if(i <= progress){
          System.out.print("█");
       }else{
          System.out.print(" ");
       }
     }
     System.out.print("| " + text + (Math.round(progress / total * 100) + 1) + "%");
   }else if(currentType == 1){
     if(created){
       for(int i = 0; i < 100; i++){
        System.out.print("\b");
       }
     }
     double modFactor = 30 / total;
      total = total * modFactor;
      progress = progress * modFactor;
     System.out.print(text + " " + Math.floor(progress / total * 100) + "% ");
     String[] chars = {"|", "/", "-", "\\", "|", "/", "-", "\\"};
     if(i>7){
       i = 0;
     }
     System.out.print(chars[i]);
     i++;
   }else{
     System.out.print(" ");
     for(int i = 0; i < 100; i++){
       System.out.print("\b\b ");
     }
   }
  }
  public String toString(){
    return "Loading icon of type " + types[currentType];
  }
  static String type(){
    return types[currentType];
  }
}

