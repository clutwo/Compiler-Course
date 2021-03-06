package yapl.test.backend;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import yapl.impl.BackendMJ;
import yapl.interfaces.BackendBinSM;

public class SimpleTest {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		BackendBinSM backend = new BackendMJ();

		backend.enterProc("writeint", 1, false);
		backend.loadWord(0, false);
		backend.writeInteger();
		backend.exitProc("writeint");
		
		backend.enterProc("main", 0, true);
		backend.loadConst(20);
		backend.callProc("writeint");
		backend.exitProc("main");
		
        backend.writeObjectFile(new FileOutputStream(args[0]));
        System.out.println("wrote object file to " + args[0]);
	}

}
