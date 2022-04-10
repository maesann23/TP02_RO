import ilog.concert.*;
import ilog.cplex.*;
public class Prob2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				try {
					IloCplex cplex = new IloCplex();
					//init var décision 
					IloNumVar xij = simplexe.numVar(0, Double.MAX_VALUE);
					
					//definir la fonction objectif
					IloLinearNumExprobjectif = simplex.linearNumExpr();
					simplexe.addMaximize();
					
					//contraintes
					simplex.addLe(simplex.sum(xij));
					simplex.addLe(simplex.sum(xij));
					//resolution
					simplex.solve();
				}
	}

}
