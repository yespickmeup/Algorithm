/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.receipts;

/**
 *
 * @author Maytopacka
 */
public class S1_receipt_barcodes {

    public static class to_receipt_barcodes {

        public final int id;
        public final String code;
        public final String barcode;

        public to_receipt_barcodes(int id,String code, String barcode) {
            this.id = id;
            this.code=code;
            this.barcode = barcode;
        }
    }
    
    
}
