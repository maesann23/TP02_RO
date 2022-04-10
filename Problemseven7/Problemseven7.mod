/*********************************************
 * OPL 12.6.0.0 Model
 * Author: nekoc
 * Creation Date: 9 avr. 2022 at 16:24:31
 *********************************************/
int nbAvions = ...;
int passager[1..nbAvions][1..nbAvions] = ...;
range I = 1..nbAvions;
range J = 1..nbAvions;
// variable de decision
dvar boolean x[I][J];
//1 if Avion provence i assure destination j.
//0 sinon.
// fonction objectif
/* maximiser le nombre de passagers restant dans l’avion. */
maximize sum(i in I)sum(j in J) x[i][j]*passager[i][j];
// les contraintes
subject to {
forall(i in I) sum(j in J) x[i][j] == 1;
forall (j in J) sum(i in I) x[i][j] == 1;
forall(i in I){
	forall(j in J){
	sum(i in I) x[i][j]<=1;
	sum(j in J) x[i][j]>=0;
}
}
}

