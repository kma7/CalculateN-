public void fizzbuzz(int n){
  for(int i = 1; i <= n; i++){
    if(i % 15 == 0){
      System.out.println("fizzbuzz");
    }else if(i % 5 == 0){
      System.out.println("buzz");
    }else if(i % 3 == 0){
      System.out.println("fizz");
    }
  }
}
