/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import busquedas.Amplitud;
import busquedas.Arista;
import busquedas.Nodo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

/**
 *
 * @author Karlo
 */
public class AreaGrafo extends javax.swing.JPanel {

    //Graphics2D g;//Se especifica donde se graficara los nodos y aristas
    boolean gnodo, garista, gmove, gselect, mover,ejecutando;//Una bandera para graficar nodos y arista
    int xm, ym;//Posicion del mouse en el area de dibujo
    int radio = 40;
    HashMap<String, int[]> nodosG;
    LinkedList<String[]> aristasG;
    Color colorVar;
    HashMap<String,Nodo> nodos;
    HashMap<String,Arista> aristas;
    String nodoEvaluado;
    Principal principal;
    String nodoSelect, inicio, fin;
    boolean drop;

    /**
     * Creates new form Grafo
     */
    public AreaGrafo(Principal principal) {
        initComponents();
        inicializar();
        colorVar=Color.GREEN.brighter();
        this.principal = principal;
        nodoEvaluado=null;
    }

    public void setArreglos(HashMap<String, int[]> nodos, LinkedList<String[]> aristas) {
        this.nodosG = nodos;
        this.aristasG = aristas;
        repaint();
    }
    public void setArreglos2(HashMap<String,Nodo> nodos, HashMap<String,Arista> aristas){
        this.nodos = nodos;
        this.aristas = aristas;
    }

    public void setActividadNodo(boolean gnodo) {
        this.gnodo = gnodo;
    }

    public void setActividadArista(boolean garista) {
        this.garista = garista;
    }

    public void setMove(boolean gmove) {
        this.gmove = gmove;
    }

    public void setSelect(boolean gselect) {
        this.gselect = gselect;
    }

    public void inicializar() {
        //g = (Graphics2D) this.getGraphics();
        gnodo = false;
        garista = false;
        gmove = false;
        gselect = false;
        xm = 0;
        ym = 0;
        nodoSelect = null;
        drop = true;
        mover = false;
        ejecutando=false;
    }

    @Override
    public void paint(Graphics g2) {
        super.paint(g2);
        Graphics2D g = (Graphics2D) g2;
        aristaTemporal(g);
        nodoTemporal(g);
        aristasGraficados(g);
        nodosGraficados(g);
    }

    public void nodoTemporal(Graphics2D g) {
        if (gnodo) {
            g.setPaint(Color.BLUE);
            Ellipse2D.Double c1 = new Ellipse2D.Double(xm - (radio / 2), ym - (radio / 2), radio, radio);
            g.draw(c1);
        }
    }

    public void aristaTemporal(Graphics2D g) {
        if (garista) {
            g.setPaint(Color.BLACK);
            if (inicio != null) {
                if (fin != null) {
                    int[] get = nodosG.get(inicio);
                    xm = get[0];
                    ym = get[1];
                }
                int[] get = nodosG.get(inicio);
                Line2D.Double dlinea = new Line2D.Double(get[0], get[1], xm, ym);
                g.draw(dlinea);
            }
        }
    }

    public void aristasGraficados(Graphics2D g) {
        ListIterator<String[]> li = aristasG.listIterator();
        while (li.hasNext()) {
            String[] next = li.next();
            int[] p1 = nodosG.get(next[0]);
            int[] p2 = nodosG.get(next[1]);
            g.setPaint(Color.BLACK);
            Line2D.Double dlinea = new Line2D.Double(p1[0], p1[1], p2[0], p2[1]);
            g.draw(dlinea);
            g.setPaint(Color.CYAN.darker());
            g.drawString(next[2],(p1[0]+p2[0])/2,(p1[1]+p2[1])/2);
        }
    }
    
    public void nodosGraficados(Graphics2D g) {
        Iterator<Map.Entry<String, int[]>> it = nodosG.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, int[]> next = it.next();
            int x, y;
            String nodo = next.getKey();
            x = next.getValue()[0];
            y = next.getValue()[1];
            //print("Graficando.....>>>>");
            if ((gselect && nodo.equals(nodoSelect))|| (ejecutando && nodo.equals(nodoEvaluado))) {
                g.setPaint(colorVar);
            } else {
                g.setPaint(Color.GREEN.darker());
            }
            Ellipse2D.Double nodoGraf = new Ellipse2D.Double(x - (radio / 2), y - (radio / 2), radio, radio);
            g.fill(nodoGraf);
            g.draw(nodoGraf);
            g.setColor(Color.WHITE.brighter());
            g.drawString(nodo, x - 3, y-2);
            g.setColor(Color.ORANGE.brighter());
            nodos.get(nodo).setX(x);
            String valor=String.valueOf(nodos.get(nodo).getValor());
            g.drawString(valor, x - (3*valor.length()), y + 12);
        }
    }
    public void resaltar(String nodoEvaluado,boolean ejecutando){
        this.nodoEvaluado=nodoEvaluado;this.ejecutando=ejecutando;
        repaint();
    }
    public void setColor(Color color){
        colorVar=color;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 736, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        xm = evt.getX();
        ym = evt.getY();
        if (gnodo) {
            repaint();
        }
        if (gmove) {
            nodoSelect = null;

        }
    }//GEN-LAST:event_formMouseMoved

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (gnodo) {
            Ingresos dialog = new Ingresos(new javax.swing.JFrame(), true);
            dialog.setNodos(nodosG, true, null);
            dialog.setVisible(true);
            if (dialog.getState()) {
                nodosG.put(dialog.getNombre(), new int[]{xm, ym});
                Nodo nod=new Nodo(dialog.getNombre(),dialog.getValor());
                nodos.put(dialog.getNombre(), nod);
                principal.setValueState(nodosG.size(), aristasG.size());
            }
            repaint();
            //principal.desactivarSeleccionNodo();
            //gnodo = false;
        } else {
            if (gselect) {
                nodoSelect = getNodo(evt.getX(), evt.getY());
                //print(nodoSelect);
            }
        }
    }//GEN-LAST:event_formMouseClicked

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        movimientoDragged(evt);
    }//GEN-LAST:event_formMouseDragged
    public void movimientoDragged(java.awt.event.MouseEvent evt) {
        if (gmove) {
            if (drop) {
                nodoSelect = getNodo(evt.getX(), evt.getY());
                drop = false;
            }
            if (nodoSelect != null) {
                nodosG.put(nodoSelect, new int[]{evt.getX(), evt.getY()});
                repaint();
            }
        } else {
            if (garista) {
                if (drop) {
                    nodoSelect = getNodo(evt.getX(), evt.getY());
                    if (nodoSelect != null) {
                        inicio = nodoSelect;
                    }
                    drop = false;
                }
                if (nodoSelect != null) {
                    mover = true;
                    xm = evt.getX();
                    ym = evt.getY();
                    //nodos.put(nodoSelect, new int[]{evt.getX(), evt.getY()});
                    repaint();
                }

            }
        }
    }
    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        xm = -60;
        ym = -60;
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        repaint();
    }//GEN-LAST:event_formMouseExited

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        if (gselect) {
            this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        } else {
            if (gmove) {
                this.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
            } else {
                if (garista) {
                    this.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
                }
            }
        }
    }//GEN-LAST:event_formMouseEntered
    
    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        drop = true;
        if (mover && inicio != null) {
            fin = getNodo(evt.getX(), evt.getY());
            if (fin != null && !inicio.equals(fin)) {
                Ingresos dialog = new Ingresos(new javax.swing.JFrame(), true);
                dialog.setNodos(nodosG, false, inicio+" - "+fin+"  |  "+fin+" - "+inicio);
                dialog.setVisible(true);
                if (dialog.getState()) {
                    addArista(dialog.getValor());
                }
                
            }
        }
        repaint();
        inicio = null;
        fin = null;
        mover = false;
    }//GEN-LAST:event_formMouseReleased
    
    public void addArista(float valor) {
            boolean insertar = true;
            if (inicio.charAt(0) < fin.charAt(0)) {
                String inicioa = inicio;
                inicio = fin;
                fin = inicioa;
            }
            String[] nuevo = {inicio, fin};
            ListIterator<String[]> li = aristasG.listIterator();
            while (li.hasNext()) {
                String[] next = li.next();
                if (next[0].equals(inicio) && next[1].equals(fin)) {
                    insertar = false;
                    break;
                }
            }
            if (insertar) {//Se inserta la arista
                aristasG.add(new String[]{inicio, fin,String.valueOf(valor)});
                aristas.put(inicio+fin,new Arista(inicio,fin,valor));
                principal.setValueState(nodosG.size(), aristasG.size());
            }
        
    }
    
    public String getNodo(int xv, int yv) {
        Iterator<Map.Entry<String, int[]>> it = nodosG.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, int[]> next = it.next();
            if ((int) (Math.pow((xv - next.getValue()[0]), 2) + Math.pow((yv - next.getValue()[1]), 2)) <= (int) Math.pow(radio, 2)) {
                return next.getKey();
            }
        }
        return null;
    }

    public void eliminar() {
        //print(gselect + "   " + nodoSelect);
        if (gselect && nodoSelect != null) {
            if (!aristasG.isEmpty()) {
                int tm = aristasG.size() - 1;
                for (int i = tm; i >= 0; i--) {
                    String[] get = aristasG.get(i);
                    if (nodoSelect.equals(get[0]) || nodoSelect.equals(get[1])) {
                        //print(get[0] + "   " + get[1] + "   :  " + i + "   " + nodoSelect);
                        aristasG.remove(i);
                        aristas.remove(get[0]+get[1]);
                    }
                }
            }
            nodosG.remove(nodoSelect);
            nodos.remove(nodoSelect);
            principal.setValueState(nodosG.size(), aristasG.size());
            repaint();
        }
    }
    
    public void ejecutar(){
        
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
