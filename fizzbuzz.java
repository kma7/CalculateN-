public void fizzbuzz(int n){
		if(n < 1){
			System.out.print("Illegal input.");
		}
		for(int i = 1; i <= n; i++){
			if(i % 15 == 0){
		      System.out.print("fizzbuzz ");
		    }else if(i % 5 == 0){
		      System.out.print("buzz ");
		    }else if(i % 3 == 0){
		      System.out.print("fizz ");
		    }else{
		    	System.out.print(i + " ");
		    }
		}
	}
