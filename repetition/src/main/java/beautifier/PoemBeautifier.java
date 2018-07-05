package com.kodilla.stream.beautifier;

public class PoemBeautifier {

	public PoemBeautifier() {
	}
		public void beautify(String txt, String decor, PoemDecorator poemdecorator) {
			String result = poemdecorator.decorate(txt, decor);
			 System.out.println("Txt after beutifier: "+result);
		}
	}

 
