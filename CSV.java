import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * this class handles csv files similar to the python package
 * for now it will have basic methods
 ***************************************************
 *To Do
 **add columns?
 ***************************************************
 *NOTE:
 *this only does basic reading and writing of a csv file
 ***************************************************
 ***************************************************
*/
public class CSV {
	
	private String fileName; //is the whole location, if it is not in the same folder
	private String splitBy; //what you are going to split this by
	BufferedReader buffRead = null;
	BufferedWriter buffWrite = null;
	
	int numColumns; 
	int numRows;
	
	
	/**
	 * constructor
	
	 */
	public CSV(String fileName, String splitBy){
		this.fileName = fileName;
		this.splitBy = splitBy;
		this.numColumns = getNumColumns();
		this.numRows = getNumRows();
	}
	/**
	 * other constructor where the default splitBy is ","
	
	 */
	public CSV(String fileName){
		this.fileName = fileName;
		this.splitBy = ",";
		this.numColumns = getNumColumns();
		this.numRows = getNumRows();
	}
	/**
	 * this method is needed for getting just a column
	 
	 */
	public int getNumColumns(){
		int returnInt = 0;
		try{
			buffRead = new BufferedReader(new FileReader(fileName));
			//does not check if null so make sure its not null or add and if to check
			return buffRead.readLine().split(splitBy).length;
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (buffRead != null) {
				try {
					buffRead.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return returnInt;
	}
	
	
	/**
	 * this method returns a String[] of the row in a csv file
	
	 */
	public String[] readRow(int row){
		String line = ""; //represents the line
		
		try{
			buffRead = new BufferedReader(new FileReader(fileName));
			int lineNum = 0; //the line number
			while ((line = buffRead.readLine()) != null) {
				if(lineNum == row){ //add an if to avoid going through the whole file and row doesn't exist
					return line.split(splitBy);
				}
				lineNum++; 
			}
		}
		//exception
	 catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (buffRead != null) {
			try {
				buffRead.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		return line.split(",");
	}
	/**
	 * this method can remove a row from a csv file 
	
	 */
	public void removeRow(int row){
		//to edit a row you need to write the whole document all over
		String[][] allRows = getAllRows(); //all the rows and columns
		
		//clear the rows
		clearAllRows();
		//write everything
		for(int i = 0; i < row; i++){
			addRow(allRows[i]);
			}
		for(int i = row+1; i< allRows.length; i++){
			addRow(allRows[i]);
		}
	}
	/**
	 * this method gets the column from a csv file
	
	 */
	public String[] readColumn(int column){
		String line = "";
		String returnStringA = "" ; //this will contain all the words in the columns
		
		try{
			buffRead = new BufferedReader(new FileReader(fileName));
			line = buffRead.readLine();
			//format reasons start by adding the first string without ","
			if(line != null){
				returnStringA = line.split(splitBy)[column];
			}
			while ((line = buffRead.readLine()) != null) {
				//have to check if the column exist or else...
				if(column < numColumns){
					returnStringA = returnStringA + "," + line.split(splitBy)[column];
				}
			}
		}
		//exception
	 catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (buffRead != null) {
			try {
				buffRead.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		//String[] returnString = null;
		return  returnStringA.split(",");	
		}
	
	/**
	 * this method gets the column from a csv file without the first line
	
	 */
	public String[] readColumn(int column, boolean skip1stLine){
		if(!skip1stLine){
			return readColumn(column);
		}
		String line = "";
		String returnStringA = ""; //this will contain all the words in the columns
		try{
			buffRead = new BufferedReader(new FileReader(fileName));
			//skip the first line
			buffRead.readLine();
			line = buffRead.readLine();
			//format reasons start by adding the first string without ","
			if(line != null){
				returnStringA = line.split(splitBy)[column];
			}
			while ((line = buffRead.readLine()) != null) {
				
				//have to check if the column exist or else...
				if(column < numColumns){
					returnStringA = returnStringA + "," + line.split(splitBy)[column];
				}
			}
		}
		//exceptions
	 catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (buffRead != null) {
			try {
				buffRead.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		//test this on an empty string later
		return returnStringA.split(",");	
		}
	/**
	 * this method adds a row to a csv file
	 
	 */
	public void addRow(String[] input){
		//in order to write put another row the input must have tha same columns as the csv
		if(input.length == numColumns){
			try {
				//use the append mode in FileWriter
				buffWrite = new BufferedWriter(new FileWriter(fileName,true));
				buffWrite.append(String.join(",",input));
				buffWrite.newLine();
				numRows++; //update the number of rows
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally{
				if(buffWrite != null){
					try{
						buffWrite.close();
					}
					catch(IOException e){
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	/**
	 * this method gets all rows in the csv file
	 
	 */
	protected String[][] getAllRows(){
		String[][] returnArray = new String[numRows][numColumns];
		for(int i = 0; i < numRows; i++){
			returnArray[i] = readRow(i);
		}
		return returnArray;
		
	}
	/**
	 * this method gets the number of rows in the csv file.

	 */
	public int getNumRows(){
		int returnInt = 0; //the line number
		try{
			buffRead = new BufferedReader(new FileReader(fileName));
			while ((buffRead.readLine()) != null) {
				returnInt++;
			}
		}
		//exceptions
	 catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (buffRead != null) {
			try {
				buffRead.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		return returnInt;
	}
	/**
	 * this method edits a whole row for a csv fle
	
	 */
	public void editRows(String[] input, int row){
		//to edit a row you need to write the whole document all over
		String[][] allRows = getAllRows(); //all the rows and columns
		allRows[row] = input; //replace the row
		//clear the rows
		clearAllRows();
		//write everything
		for(int i = 0; i < allRows.length; i++){
			addRow(allRows[i]);
		}
		
	}
	/**
	 * this method edits a column in a row in the csv file
	 
	 */
	public void editColumn(String input, int row, int column){
		String[] rowString = readRow(row); //get the whole row
		rowString[column] = input; //replace the column
		editRows(rowString,row); //put it in the csv file
	}
	
	/**
	 * this method clears all rows in the csv file

	 */
	protected void clearAllRows(){
		try {
			//use the append mode in FileWriter
			buffWrite = new BufferedWriter(new FileWriter(fileName));
			buffWrite.write("");
			
			numRows = 0; //update the number of rows
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if(buffWrite != null){
				try{
					buffWrite.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
	

}
