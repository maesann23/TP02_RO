import ilog.concert.*;
import ilog.cplex.*;

public class TP2 {
	public static void main(String[] args) {
		problem2();
	}
		public static void problem2(){// TODO Auto-generated method stub
			int m = 6; //machine. .
			int n = 6; //person. .
			double[][] p = 
				    {{13, 24, 31, 19, 40, 29},
					{18, 25, 30, 15, 43, 22},
					{20, 20, 27, 25, 34, 33},
					{23, 26, 28, 18, 37, 30},
					{28, 33, 34, 17, 38, 20},
					{19, 36, 25, 27, 45, 24}}; 
			//productive assignment person i to machine j. .
			//x = 1 affected person i to machine j. .
			//x = 0 otherwise. .
			for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                System.out.print(p[i][j] + " ");
	            }
	            System.out.println(); //2D matrix show-case. .
	        }
			
			// define new model
			try {
				IloCplex cplex = new IloCplex();
				// decision variables
				IloNumVar[][] x = new IloNumVar[m][n];
				 x = simplex.numVar(0,1);
				for(int i=0; i<m; i++) {
					x[i] = cplex.boolVarArray(n);
				}
				
				IloLinearNumExpr objective = cplex.linearNumExpr();
				for(int i=0; i<n; i++) {
					for(int j=0; j<m; j++) {
						objective.addTerm(x[i][j], p[i][j]);
				}
				// define objective
				cplex.addMaximize(objective);
				// constraints
				for(i=0; i<m; i++) {
				IloLinearNumExpr expr = cplex.linearNumExpr();
				for(int j=0; j<n; j++) {
					expr.addTerm(1.0, x[i][j]);
				}
					
					cplex.addEq(expr, 1.0);
				}
				for(int j=0; j<m; j++) {
					IloLinearNumExpr expr = cplex.linearNumExpr();
					for( i=0; i<n; i++) {
						expr.addTerm(1.0, x[i][j]);
					}
						
						cplex.addEq(expr, 1.0);
					}
				
				cplex.setParam(IloCplex.Param.Simplex.Display, 0);
				//solve model
				if(cplex.solve()) {
					System.out.println("obj = "+cplex.getObjValue());
				}else {
					System.out.println("Problem not solved.");
				}
				cplex.end();
			}} catch (IloException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		
		
	