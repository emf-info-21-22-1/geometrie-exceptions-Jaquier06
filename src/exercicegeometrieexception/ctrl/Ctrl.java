package exercicegeometrieexception.ctrl;

import exercicegeometrieexception.ihm.IIhmCtrl;
import exercicegeometrieexception.wrk.IWrkCtrl;

public class Ctrl implements ICtrlIhm {

    private IIhmCtrl refIhm;
    private IWrkCtrl refWorker;

    public void demarrer() {
        refIhm.demarrer();
    }

    @Override
    public void selectCalcRadius(String value) {

        try {
            double valueDouble = Double.parseDouble(value);
            refIhm.afficheResultatCircle(String.valueOf(refWorker.calcRadiusCircleFromArea(valueDouble)));
            if (valueDouble < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            refIhm.afficheMessage("ERREUR !!! Les nombres entrés en paramètre sont incorrects");
        }
    }

    @Override
    public void selectCalcLargeur(String valueArea, String valueLongueur) {
        try {
            double valueAreaDouble = Double.parseDouble(valueArea);
            double valueLongueurDouble = Double.parseDouble(valueLongueur);
            refIhm.afficheResultatRectangle(String.valueOf(refWorker.calcLargeurFromRectangle(valueAreaDouble, valueLongueurDouble)));
            if (valueAreaDouble < 0 || valueLongueurDouble < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            refIhm.afficheMessage("ERREUR !!! Les nombres entrés en paramètre sont incorrect");
        }
    }

    public void setRefIhm(IIhmCtrl refIhm) {
        this.refIhm = refIhm;
    }

    public void setRefWorker(IWrkCtrl refWorker) {
        this.refWorker = refWorker;
    }

}
