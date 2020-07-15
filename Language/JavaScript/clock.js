var dab;
	
	var count = 5;
	
	function makeRandom(){
		dab = Math.floor(Math.random() * 100) + 1;
		
	}
	
	 function collec(input){
		this.input = prompt('맞춰보세요. 남은기회 :'+count,'');
		
		return this.input;
	}
	 
	  function upDown(input){
		if(this.input<dab){
			alert("Up");
			count--;
		}
		else if(this.input>dab){
			alert("down");
			count--;
		}
		else{
			alert("정답!");
			document.write(dab);
			break;
		}
	}  
	  
	  
	function play(){
		alert("게임시작.");
		 	makeRandom();
		while (count>0) {
			
			upDown(collec());
		}
	}
		