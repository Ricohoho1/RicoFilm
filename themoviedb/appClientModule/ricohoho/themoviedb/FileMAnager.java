package ricohoho.themoviedb;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileMAnager {
	
	public List<Fichier> listeFichiersFilm =null;
	public List<String> listeDossierFilm = null;
	
	public static void main(String[] args) {
		String pathFilm = "\\\\nos-rico\\video\\Films\\2018\\201802\\";
		//String pathFilm = "C:\\tempo\\test\\";
		FileMAnager _fileManager= new FileMAnager();
		
		_fileManager.parseDossier(pathFilm);	
		//----------- liste des filmes
		System.out.println("count fichoer:"+_fileManager.listeFichiersFilm.size());
		for(int i=0; i<_fileManager.listeFichiersFilm.size(); i++) {
			//System.out.println("_fileManager.listeFichiersFilm:"+_fileManager.listeFichiersFilm.get(i).nom);
		}
		System.out.println("count folder:"+_fileManager.listeDossierFilm.size());
		//----------- liste des Doosier
		for(int i=0; i<_fileManager.listeDossierFilm.size(); i++) {
			System.out.println("_fileManager.listeDossierFilm:"+_fileManager.listeDossierFilm.get(i));
		}
	}
	
	public List<Fichier> getListeFichiersFilm() {
		return listeFichiersFilm;
	}

	public List<String> getListeDossierFilm() {
		return listeDossierFilm;
	}

	/*
	 * Constructor
	 */
	FileMAnager() {
		//
	}
			
	/**
	 * 
	 * @param path
	 * @return
	 */
	public void parseDossier(String path) { 
		System.out.println("Path="+path);
		listeFichiersFilm = new ArrayList<Fichier>();
		listeDossierFilm = new ArrayList<String>();
		String filtre = "(.)*.(avi|mkv|mp4)";
		try {
			Pattern p = Pattern.compile(filtre); 
			//String [] s = new File(path).list(); 
			File[] s_files = new File(path).listFiles();
			//System.out.println("s.length="+s.length);
			
			String s=""; 
			for (int i=0; i<s_files.length;i++) {
				s=s_files[i].getName();
				Matcher m = p.matcher(s);
				//System.out.println("matcher");									
				if (s_files[i].isFile()) {
					if ( m.matches()) { 
						//System.out.println("  ==> Match");
						System.out.println("film="+s);
						
						File file =new File(path+s);
						double bytes=0;
						Date dateFichier=null;
						if(file.exists()){
							bytes = file.length();
							
							long fileTime;
							
							try {
								 fileTime = file.lastModified();
								 dateFichier = new Date(fileTime);
							} catch (Exception e) {
							    System.err.println("Cannot get the last modified time - " + e);
							}
						}																		
						this.listeFichiersFilm.add(new Fichier(path,s,bytes,dateFichier)); 
					} else {
						System.out.println("  ==> Not Match"+s);
					}  
				} else  if (s_files[i].isDirectory()) { //Folder
					listeDossierFilm.add(s_files[i].getPath());
					System.out.println("  ==> ssDossier"+s_files[i].getPath());
				}
			}
		}  catch (Exception pse) { 
			System.out.println("Le dossier : "+ path+" n'existe pas!!");
			//pse.printStackTrace(); 		 
		} 
		//List<String> wordList = Arrays.asList(words);  
		//return listeFichiersFilm ;
	}
	/*
	void initFilm(String path) {
		this.listeFichiersFilm = this.getPAthFile(path);
	}
	*/
	
}
