import java.io.*;
import java.util.*;
import org.apache.commons.lang3.StringUtils;


class ReadFileNames
{
	int v = 0;
	String filenamearray[];
	public void listFilesForFolder(File folder) 
	{
	    int z =0;
	    
	    for(final File fileEntry : folder.listFiles()) 
	    {
	    	 if (fileEntry.isDirectory()) 
	    	 {
	    		 //do nothing
		     } 
	    	 else 
	    	 {
		    	z++;
		     }		
		}
	  
	    filenamearray = new String[z];	    
	    
		for(final File fileEntry : folder.listFiles()) 
		{
	        if (fileEntry.isDirectory()) 
	        {
	            listFilesForFolder(fileEntry);
	        } 
	        else 
	        {
	            filenamearray[v] = fileEntry.getName();
	            v++;
	        }
	    }
	}	
}


class IRProj1 extends ReadFileNames
{
	int v1=0;
	int docId = 1;
	static FileReader fr;
	static BufferedReader in;
	static FileWriter fw2;
	static FileWriter fw3;
	static BufferedWriter out1;
	static BufferedWriter out2;
	static BufferedWriter out3;

	ArrayList<String> nonsortedtermanddocid = new ArrayList<String>();	
	
	public void proj1(String argument2, String argument3) throws IOException 
	{
		fw2 = new FileWriter(argument3);
		out2 = new BufferedWriter(fw2);
		
		fw3 = new FileWriter(argument2);
		out3 = new BufferedWriter(fw3);
	
		do 
		{		
			ArrayList<String> dictionary = new ArrayList<String>();
			fr = new FileReader("F:/BU Study/Sem 1/IR/Programming Assignment/Level 2/Reviews/" + filenamearray[v1]);		
			in = new BufferedReader(fr);
			String line;

			while((line=in.readLine())!=null)
			{
				String s1 = line.replaceAll("\\<.*?>"," ");
				s1 = s1.replace("'s", " ");
				s1 = s1.replace("-"," ");
				s1 = s1.replaceAll("\\s+"," ");
				s1 = s1.toLowerCase();

				String token[] = s1.split("\\s");
			
				for(int i=0;i<token.length;i++)
				{				
					
					for(int k=0;k<(token[i].length()-1);k++)
					{							
						if(token[i].startsWith("\'"))
						{
							StringBuffer sb = new StringBuffer(token[i]);
							sb = sb.replace(0, (sb.length()-(sb.length()-1))," ");
							token[i] = sb.toString();
						}
			
						if(token[i].startsWith("\""))
						{
							StringBuffer sb = new StringBuffer(token[i]);
							sb = sb.replace(0, (sb.length()-(sb.length()-1))," ");
							token[i] = sb.toString();
						}
			
						if(token[i].startsWith("("))
						{
							StringBuffer sb = new StringBuffer(token[i]);
							sb = sb.replace(0, (sb.length()-(sb.length()-1))," ");
							token[i] = sb.toString();
						}	
			
						if(token[i].startsWith(")"))
						{
							StringBuffer sb = new StringBuffer(token[i]);
							sb = sb.replace(0, (sb.length()-(sb.length()-1))," ");
							token[i] = sb.toString();
						}
			
						if(token[i].startsWith("["))
						{
							StringBuffer sb = new StringBuffer(token[i]);
							sb = sb.replace(0, (sb.length()-(sb.length()-1))," ");
							token[i] = sb.toString();
						}
			
						if(token[i].startsWith("]"))
						{
							StringBuffer sb = new StringBuffer(token[i]);
							sb = sb.replace(0, (sb.length()-(sb.length()-1))," ");
							token[i] = sb.toString();
						}	
			
						if(token[i].endsWith("\'"))
						{
							StringBuffer sb = new StringBuffer(token[i]);
							sb = sb.replace(sb.length()-1, sb.length()," ");
							token[i] = sb.toString();
						}
					
						if(token[i].endsWith("\""))
						{
							StringBuffer sb = new StringBuffer(token[i]);
							sb = sb.replace(sb.length()-1, sb.length()," ");
							token[i] = sb.toString();
						}	
					
						if(token[i].endsWith("("))
						{
							StringBuffer sb = new StringBuffer(token[i]);
							sb = sb.replace(sb.length()-1, sb.length()," ");
							token[i] = sb.toString();
						}
			
						if(token[i].endsWith(")"))
						{
							StringBuffer sb = new StringBuffer(token[i]);
							sb = sb.replace(sb.length()-1, sb.length()," ");
							token[i] = sb.toString();
						}
			
						if(token[i].endsWith("["))
						{
							StringBuffer sb = new StringBuffer(token[i]);
							sb = sb.replace(sb.length()-1, sb.length()," ");
							token[i] = sb.toString();
						}	
			
						if(token[i].endsWith("]"))
						{
							StringBuffer sb = new StringBuffer(token[i]);
							sb = sb.replace(sb.length()-1, sb.length()," ");
							token[i] = sb.toString();
						}
			
						if(token[i].endsWith(","))
						{
							StringBuffer sb = new StringBuffer(token[i]);
							sb = sb.replace(sb.length()-1, sb.length()," ");
							token[i] = sb.toString();
						}	
			
						if(token[i].endsWith("."))
						{
							StringBuffer sb = new StringBuffer(token[i]);
							sb = sb.replace(sb.length()-1, sb.length()," ");
							token[i] = sb.toString();
						}		
			
						if(token[i].endsWith("?"))
						{
							StringBuffer sb = new StringBuffer(token[i]);
							sb = sb.replace(sb.length()-1, sb.length()," ");
							token[i] = sb.toString();
						}
			
						if(token[i].endsWith(":"))
						{
							StringBuffer sb = new StringBuffer(token[i]);
							sb = sb.replace(sb.length()-1, sb.length()," ");
							token[i] = sb.toString();
						}
			
						if(token[i].endsWith(";"))
						{
							StringBuffer sb = new StringBuffer(token[i]);
							sb = sb.replace(sb.length()-1, sb.length()," ");
							token[i] = sb.toString();
						}
			
						if(token[i].endsWith("!"))
						{
							StringBuffer sb = new StringBuffer(token[i]);
							sb = sb.replace(sb.length()-1, sb.length()," ");
							token[i] = sb.toString();
						}			
						token[i] = token[i].trim();			
					}				
						
					if(token[i].length() > 4)
					{
						if((token[i].substring( (token[i].length()-4),token[i].length()).equals("aies")) 
							| (token[i].substring( (token[i].length()-4),token[i].length()).equals("eies")))
						{
						//do nothing
						continue;
						}
						else if((token[i].substring( (token[i].length()-3),token[i].length()).equals("ies")))
						{
							StringBuffer sb = new StringBuffer(token[i]);
							sb = sb.replace((sb.length()-3), sb.length(),"y");
							token[i] = sb.toString();
							continue;
						}
					}	
			
					if(token[i].length() > 3)
					{
						if((token[i].substring( (token[i].length()-3),token[i].length()).equals("aes")) 
							| (token[i].substring( (token[i].length()-3),token[i].length()).equals("ees"))
							| (token[i].substring( (token[i].length()-3),token[i].length()).equals("oes")))
						{
							//do nothing
							continue;
						}
						else if((token[i].substring( (token[i].length()-2),token[i].length()).equals("es")))
						{
							StringBuffer sb = new StringBuffer(token[i]);
							sb = sb.replace(sb.length()-2, sb.length(),"e");
							token[i] = sb.toString();
							continue;
						}
					}
			
					if(token[i].length() > 2)
					{
						if((token[i].substring( (token[i].length()-2),token[i].length()).equals("us")) | (token[i].substring( (token[i].length()-2),token[i].length()).equals("ss")))
						{
							//do nothing
							continue;
						}
						else if(token[i].length() > 3)
						{
							if((token[i].substring( (token[i].length()-1),token[i].length()).equals("s")))			
							{
								StringBuffer sb = new StringBuffer(token[i]);
								sb = sb.replace(sb.length()-1, sb.length(),"");
								token[i] = sb.toString();
								continue;
							}
						}
					}			
				}
				
				for(int j=0; j<token.length; j++)
				{
					if(token[j].length()!=1)
					{
						token[j] = token[j].trim();
						//	UpdatedDict[j] = token[j];
						dictionary.add(token[j]);			
					}				
				}	

				dictionary.remove("and");
				dictionary.remove("the");
				dictionary.remove("an");
				dictionary.remove("by");
				dictionary.remove("from");
				dictionary.remove("for");
				dictionary.remove("hence");
				dictionary.remove("of");
				dictionary.remove("with");
				dictionary.remove("in");
				dictionary.remove("within");
				dictionary.remove("who");
				dictionary.remove("when");
				dictionary.remove("why");
				dictionary.remove("how");
				dictionary.remove("whom");
				dictionary.remove("have");
				dictionary.remove("had");
				dictionary.remove("has");
				dictionary.remove("not");
				dictionary.remove("but");
				dictionary.remove("do");
				dictionary.remove("does");
				dictionary.remove("done");
				
				Collections.sort(dictionary);									
			}	//readLine						
					
			for(String x:dictionary)
			{
				if(x.trim().length()>0)
				{			
					nonsortedtermanddocid.add(x + "," + String.valueOf(docId)); //it was taking ascii value of docId				
				}
			}	
			docId = docId + 1;			
			v1++;		
		}while(v1<filenamearray.length);

	in.close();
	}
}


class IRProj2 extends IRProj1
{
	static FileReader fr1;
	static FileReader fr2;
	static FileReader fr3;
	static BufferedReader in1;
	static BufferedReader in2;
	static BufferedReader in3;	
	static FileWriter fw1;
	public static boolean status;
	static int offset = 0;

	//for postings.csv
	ArrayList<String> termlist = new ArrayList<String>();	//for storing sorted terms from list - sortedtermanddocid
	ArrayList<String> docidlist = new ArrayList<String>();	//for storing sorted docid from list - 
	
	public void proj2(String argument4) throws IOException
	{
		Collections.sort(nonsortedtermanddocid);	//becomes sorted
				
		//for dictionary.csv
		ArrayList<String> termlist1 = new ArrayList<String>();	//for storing sorted terms from list - sortedtermanddocid
		ArrayList<String> docidlist1 = new ArrayList<String>();	//for storing sorted docid from list - sortedtermanddocid		
		
		String linefromstndidlist;
		
		for(int z1=0;z1<nonsortedtermanddocid.size();z1++) 
		{
			linefromstndidlist = nonsortedtermanddocid.get(z1);		
			String[] tokenstndidlist = linefromstndidlist.split(",");
			termlist.add(tokenstndidlist[0]);
			termlist1.add(tokenstndidlist[0]);
			docidlist.add(tokenstndidlist[1]);
			docidlist1.add(tokenstndidlist[1]);
		}		
		
		//Postings Part	
		
		for(int b1 = 0;b1<termlist.size();b1++)
		{
			int tf=1;
			for(int b2 = b1+1;b2<termlist.size();b2++)
			{
				if(termlist.get(b1).matches(" ")) 
				{
					break;
				}
				else if(termlist.get(b1).equals(termlist.get(b2)) & docidlist.get(b1).equals(docidlist.get(b2)))
				{
					termlist.remove(b2);
					termlist.add(b2," ");
					docidlist.remove(b2);
					docidlist.add(b2," ");
					tf = tf + 1;
				}		
			}
			String term = termlist.get(b1);
			
			if(term!=" ")
			{
				out2.write(docidlist.get(b1)  +","+  tf);
				out2.newLine();
			}			
		}
		out2.close();		
		termlist.remove(" ");		//for and terms processing
		docidlist.remove(" ");		//for and terms processing
			
	//Dictionary Part	
		
		for(int pc1=0;pc1<termlist1.size();pc1++)
		{
			int df=1;
			
			for(int pc2=pc1+1;pc2<termlist1.size();pc2++)
			{
				if(termlist1.get(pc1)!=" ")
				{					
					if(termlist1.get(pc1).equals(termlist1.get(pc2)))
					{
						termlist1.remove(pc2);
						termlist1.add(pc2," ");
						if(docidlist1.get(pc1).equals(docidlist1.get(pc2)))
						{
							docidlist1.remove(pc2);
							docidlist1.add(pc2," ");
							//df = df + 1;
						}
						else
						{
							df = df + 1;
							docidlist1.remove(pc2);
							docidlist1.add(pc2," ");
						}
					}
				}
			}
		
			if(termlist1.get(pc1)!=" ")
			{
				out3.write(termlist1.get(pc1) + "," + df + ","+ offset);
				out3.newLine();
				offset = offset + df;
			}				
		}
		out3.close();
	
		//Code for Document Table
		//filenamearray for filenames

		fw1 = new FileWriter(argument4);
		out1 = new BufferedWriter(fw1);
		
		int docidforretrieval[] = new int[filenamearray.length];
		int v2=0;
		String title="";
		String reviewer = "";
		String line2;
		String line3;
		String concatsnippetline = "";
		int linecount=0;
		String rate="";
		String rate1 = "";
		
		ArrayList<String> titledoctab = new ArrayList<String>();	
		ArrayList<String> reviewerdoctab = new ArrayList<String>();	
		ArrayList<String> snippetdoctab = new ArrayList<String>();	
		ArrayList<String> ratedoctab = new ArrayList<String>();	
		
		do
		{
			String line1;						
			fr1 = new FileReader("F:/BU Study/Sem 1/IR/Programming Assignment/Level 2/Reviews/" + filenamearray[v2]);		
			in1 = new BufferedReader(fr1);
	
			while((line1=in1.readLine())!=null)
			{
				title = StringUtils.substringBetween(line1 , "<TITLE>", "</TITLE>");			
				reviewer = StringUtils.substringBetween(line1 , "/ReviewsBy", ">");
				reviewer = StringUtils.replaceAll(reviewer, "\\?", "\0");
				reviewer = StringUtils.replaceAll(reviewer, "\\+", "\0");
				reviewer = StringUtils.replaceAll(reviewer, "\"", "\0");
				//reviewer = StringUtils.replaceAll(reviewer, ",", "\0");
				
				if(title != null) 
				{
					titledoctab.add(title);
				}
				if(reviewer != null) 
				{
					reviewerdoctab.add(reviewer);
				}								
			}
			
			//Add code for snippet and rate here
			//take new filereader object or it wont work
			fr2 = new FileReader("F:/BU Study/Sem 1/IR/Programming Assignment/Level 2/Reviews/" + filenamearray[v2]);		
			in2 = new BufferedReader(fr2);					 
			 
			while((line2 = in2.readLine()) != null) 
			{
				 if(StringUtils.containsIgnoreCase(line2, "</PRE>"))
				 {
					 status = true;
					 continue;
				 }
				 
				 if(status == true && linecount<8)
				 {
					 concatsnippetline = concatsnippetline +" "+ line2;
					 concatsnippetline = StringUtils.replaceAll(concatsnippetline, "<P>", "");
					 concatsnippetline = StringUtils.replaceAll(concatsnippetline, "</P>", "");
					 linecount++;
				 }
				 else if(linecount>7) 
				 {
					 break; // breaks the while loop
				 }
			}
			snippetdoctab.add(concatsnippetline);

			//Add code for rate here
			fr3 = new FileReader("F:/BU Study/Sem 1/IR/Programming Assignment/Level 2/Reviews/" + filenamearray[v2]);		
			in3 = new BufferedReader(fr3);
				
			while ((line3 = in3.readLine()) != null) 
			{					 
				if(StringUtils.containsIgnoreCase(line3,"-4 to +4 scale"))
				{
					rate = StringUtils.substringBefore(line3, "-4 to +4 scale");      
					rate = rate.replaceAll("[^-?0-9]+", " ");
					rate = rate.replaceAll("\\s+","");
					rate = rate.replaceAll("\\s","");
						 
					if(rate.length()>1) 
					{
						String c1 = Character.toString(rate.charAt(rate.length()-2));
						String c2 = Character.toString(rate.charAt(rate.length()-1));
						 
						if(c1.matches("-")) 
						{
							rate1 = c1 + c2; 					
						}
						else 
						{
							rate1 = c2;							 
						}
					}
					else		//if length is 1 
					{
						rate1 = rate;
					}						
				}
				else 
				{
					//do nothing	 
				}
			}				 
				
			if(rate1!=null) 
			{
				ratedoctab.add(rate1);
			}		 
			v2++;			
		}while(v2<filenamearray.length);
		
		for(int anbu=0;anbu<filenamearray.length;anbu++)
		{
			docidforretrieval[anbu] = anbu + 1;			
		}
		
		for(int ap=0;ap<filenamearray.length;ap++)
		{
			out1.write(docidforretrieval[ap] + "," + filenamearray[ap] +","+ titledoctab.get(ap) 
					+ "," + reviewerdoctab.get(ap)+ "," + snippetdoctab.get(ap) +","+ ratedoctab.get(ap));					
			out1.newLine();
		}			
		in1.close();
		in2.close();
		in3.close();
		out1.flush();
		out1.close();		
	}
}

class IRProj3 extends IRProj2
{
	static FileReader fr4;
	static FileWriter fw4;
	static BufferedReader in4;
	static BufferedWriter out4;
	
	public void proj3(String argument4, String argument5) throws IOException
	{
		int posofandnot;
		int andtermpresent =1;
		ArrayList<String> inputqueryal = new ArrayList<String>();	
		ArrayList<String> andterms = new ArrayList<String>();	//list containing terms of and query
		ArrayList<String> andnotterms = new ArrayList<String>();//list containing containing terms of andnot query
		ArrayList<String> orterms = new ArrayList<String>();
		ArrayList<String> anddocidlistforretrieval = new ArrayList<String>();//for storing docids for and terms
		ArrayList<String> andnotdocidlistforretrieval = new ArrayList<String>();
		ArrayList<String> ordocidlistforretrieval = new ArrayList<String>();
		ArrayList<String> finalanddocidlistforretrieval = new ArrayList<String>();		
		
		fw4 = new FileWriter(argument5);
		out4 = new BufferedWriter(fw4);
				
		while(true)
		{
			fr4 = new FileReader(argument4);		
			in4 = new BufferedReader(fr4);
			InputStreamReader readthequeryisr = new InputStreamReader(System.in);
			BufferedReader readthequerybr = new BufferedReader(readthequeryisr);
			System.out.println("Enter Query:");
				
			String query = readthequerybr.readLine();
			if(query.equalsIgnoreCase("Exit"))
			{
				System.exit(0);
			}
			query = query.toLowerCase();
			String[] inputquery = query.split("\\s");

			for(int f1 = 0;f1<inputquery.length;f1++)
			{
				inputqueryal.add(inputquery[f1]);	//added all terms in the query to arraylist
			}
			
			int lengthofinputqueryal = inputqueryal.size();
					
			if(inputqueryal.contains("andnot"))
			{
				posofandnot = inputqueryal.indexOf("andnot");	//to get position of 'andnot'
		
				for(int f2 = 1;f2<posofandnot;f2++)		//because at 0 the term is and
				{
					andterms.add(inputqueryal.get(f2));		//added all the terms for 'and' query
				}				
				for(int f3 = posofandnot+1;f3<lengthofinputqueryal;f3++)
				{
					andnotterms.add(inputqueryal.get(f3));  //added all the terms for 'andnot' query
				}
				
				//get all docids for 'and' terms
				for(int f4=0; f4<andterms.size() ;f4++)
				{				
					for(int f5=0; f5<termlist.size() ;f5++)
					{
						if(andterms.get(f4).equals(termlist.get(f5)))
						{
							anddocidlistforretrieval.add(docidlist.get(f5));
						}
					}				
				}	
				//if docid for 'and' terms repeated andterms.size(), docid stored
				
				for(int f6=0; f6<anddocidlistforretrieval.size() ;f6++)
				{
					for(int f7=f6+1; f7<anddocidlistforretrieval.size() ;f7++)
					{
						if(anddocidlistforretrieval.get(f6).equals(anddocidlistforretrieval.get(f7)))		
						{
							andtermpresent = andtermpresent + 1;							
						}
						if(andtermpresent == andterms.size())
						{
							finalanddocidlistforretrieval.add(anddocidlistforretrieval.get(f6));
							andtermpresent = 1;
						}
					}
				}
							
				//getting docids for 'andnot' terms
				
				for(int f8=0; f8<andnotterms.size() ;f8++)
				{				
					for(int f9=0; f9<termlist.size() ;f9++)
					{
						if(termlist.get(f9).equals(andnotterms.get(f8)))
						{
							andnotdocidlistforretrieval.add(docidlist.get(f9));
						}
					}
				}
				//remove duplicates from andnotdocidlistforretrieval
				
				for(int f10=0; f10<andnotdocidlistforretrieval.size() ;f10++)
				{
					for(int f11=f10+1; f11<andnotdocidlistforretrieval.size() ;f11++)
					{
						if(andnotdocidlistforretrieval.get(f10).equals(andnotdocidlistforretrieval.get(f11)))		
						{
							andnotdocidlistforretrieval.remove(f11);						
						}						
					}
				}
				
				
				for(int f13=0; f13<finalanddocidlistforretrieval.size() ;f13++)
				{
					for(int f14=0; f14<andnotdocidlistforretrieval.size() ;f14++)
					{
						if(finalanddocidlistforretrieval.get(f13).equals(andnotdocidlistforretrieval.get(f14)))		
						{
							finalanddocidlistforretrieval.remove(f13);						
						}						
					}
				}				
				//get from document table for doc id in finalanddocidlistforretrieval				
			}
			else if(inputqueryal.contains("and"))	//if query only contains 'and'
			{			
				for(int f2 = 1; f2<inputqueryal.size() ;f2++)		//because at 0 the term is and
				{
					andterms.add(inputqueryal.get(f2));		//added all the terms for 'and' query
				}
				
				//get all docids for 'and' terms
				for(int f4=0; f4<andterms.size() ;f4++)
				{				
					for(int f5=0; f5<termlist.size() ;f5++)
					{
						if(termlist.get(f5).equals(andterms.get(f4)))
						{
							anddocidlistforretrieval.add(docidlist.get(f5));
						}
					}				
				}	
	
				//if docid for 'and' terms repeated andterms.size(), docid stored
				
				for(int f6=0; f6<anddocidlistforretrieval.size() ;f6++)
				{
					for(int f7=f6+1; f7<anddocidlistforretrieval.size() ;f7++)
					{
						if(anddocidlistforretrieval.get(f6).equals(anddocidlistforretrieval.get(f7)))		
						{
							andtermpresent = andtermpresent + 1;						
						}
					}	
					
					if(andtermpresent == andterms.size())
					{
						finalanddocidlistforretrieval.add(anddocidlistforretrieval.get(f6));
						andtermpresent = 1;
					}					
				}
				//now get ans from document table for the doc ids in finalanddocidlistforretrieval					
			}
			else if(inputqueryal.contains("or"))
			{
				for(int bing = 1; bing<inputqueryal.size() ;bing++)		//because at 0 the term is 'or'
				{
					orterms.add(inputqueryal.get(bing));		//added all the terms for 'or' query
				}
				
				//get all docids for 'or' terms
				for(int bing1=0; bing1<orterms.size() ;bing1++)
				{				
					for(int bing2=0; bing2<termlist.size() ;bing2++)
					{
						if(termlist.get(bing2).equals(orterms.get(bing1)))
						{
							ordocidlistforretrieval.add(docidlist.get(bing2));
						}
					}				
				}	
				
				//removing duplicate docids
				for(int bing3=0; bing3<ordocidlistforretrieval.size() ;bing3++)
				{
					for(int bing4=bing3+1; bing4<ordocidlistforretrieval.size() ;bing4++)
					{
						if(ordocidlistforretrieval.get(bing3).equals(ordocidlistforretrieval.get(bing4)))		
						{
							ordocidlistforretrieval.remove(bing4);						
						}						
					}
				}
				
				//transfer elements from ordocidlistforretrieval to finalanddocidlistforretrieval
				for(int bing5=0; bing5<ordocidlistforretrieval.size() ;bing5++)
				{
					finalanddocidlistforretrieval.add(ordocidlistforretrieval.get(bing5));
				}			
			}
			else
			{
				System.out.println("Invalid Command!!!!!!!");
			}
					
			String linefinal;
			
			while ((linefinal = in4.readLine()) != null) 
			{
				if(finalanddocidlistforretrieval.isEmpty())
				{
					System.out.println("No Results!!!");
					System.exit(0);
				}
				for(int anbu1 = 0; anbu1<finalanddocidlistforretrieval.size() ; anbu1++)
				{
					if(StringUtils.startsWith(linefinal, finalanddocidlistforretrieval.get(anbu1) ))
					{
						System.out.println("Query:" +query);
						System.out.println(linefinal);
						System.out.println();
						out4.write("Query:" +query);
						out4.newLine();
						out4.write(linefinal);
						out4.newLine();
						out4.newLine();
						out4.newLine();						
					}
				}
			}

			query = "";
			inputquery = null;
			inputqueryal.clear();
			andterms.clear();
			andnotterms.clear();
			orterms.clear();
			anddocidlistforretrieval.clear();
			andnotdocidlistforretrieval.clear();
			ordocidlistforretrieval.clear();
			finalanddocidlistforretrieval.clear();
			
			out4.flush();		
		}
	}
}

public class IRProject extends IRProj3
{	
	static String f1;
	static String filenamearray[];	//use array to store filenames
	static String filenamearraydoctab[];
	static FileWriter fw;
	static BufferedWriter out;
	static int z=0;
	
	public static void main(String args[]) throws IOException
	{
		String argument1 = args[0];
		String argument2 = args[1];
		String argument3 = args[2];
		String argument4 = args[3];
		String argument5 = args[4];

		final File folder = new File(argument1);
		IRProject obj1 = new IRProject();		
		obj1.listFilesForFolder(folder);		
		obj1.proj1(argument2, argument3);
		obj1.proj2(argument4);
		obj1.proj3(argument4, argument5);	
	}	
}		

