package inncectionCapitolo4;

import javafx.scene.input.*;
import java.nio.*;
import java.util.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class PaginaPrincipale extends Application implements PixelReader {
	List<Node> listaOggetti = new ArrayList<Node>();
	
	@Override
	public void start(Stage stage) throws Exception {
		
		Pane pane_root = new Pane();
		HBox hbox = new HBox();
		HBox hbox_vuoto = new HBox();
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		
		Text txt_testataPagina = new Text("Seleziona l'oggetto");
		txt_testataPagina.setFont(new Font(24));
		Button btn_start = new Button("Start");
		btn_start.setFont(new Font(19));
		//Rectangle rect = new Rectangle(250,250);
		// inncectionCapitolo4\\creeper_face.jpg
		//Carichiamo l'immagine di nostro interesse sull'oggetto Image
		Image creeper_image = new Image("inncectionCapitolo4\\creeper_face.jpg",200,200,false,false);
		Image circle_image = new Image("inncectionCapitolo4\\cerchio.jpg",200,200,false,false);
		Image jetFighter_image = new Image("inncectionCapitolo4\\carro_armatoProva.jpg",200,200,false,false);
		
		ImageView imageView1 = new ImageView(creeper_image);
		ImageView imageView2 = new ImageView(circle_image);
		ImageView imageView3 = new ImageView(jetFighter_image);
		
		imageView1.setId("1");
		imageView2.setId("2");
		imageView3.setId("3");
		
		//System.out.println("toString : " + btn_start.toString());
		//System.out.println("toString : " + btn_start.hashCode());

		//Applichiamo lo stile CSS al bottone:
		//imageView1.setStyle("-fx-background-color: red");
		//imageView1.setOnMouseClicked(e -> btn_start imageView1);
		DropShadow effectShadow = new DropShadow();
		
		listaOggetti.add(imageView1);
		listaOggetti.add(imageView2);
		listaOggetti.add(imageView3);
		listaOggetti.add(btn_start);
		
		//listaOggetti.forEach( e -> System.out.println("Obj ->" + e.hashCode()));
		//imageView1.setEffect(effectShadow);
		
		EventHandler<MouseEvent> eventHandlerClicked = new EventHandler<MouseEvent>() { 
			
			 @Override 
	         public void handle(MouseEvent e) { 
				ImageView imageStore = (ImageView) e.getSource();
				
				System.out.println(imageStore.getId());
	        	if(true) { 
	        	
	        		effectShadow.setColor(Color.BLUE);
	     			effectShadow.setBlurType(BlurType.THREE_PASS_BOX);
	     			effectShadow.setRadius(0);
	     			effectShadow.setHeight(15);
	     			effectShadow.setWidth(15);
	     			effectShadow.setSpread(10); 
	     			
	     			//Rimuoviamo l'effetto dagli altri:
	     			for (Node n : listaOggetti) {
	     				n.setEffect(null);
					}
	     		
	     			//Applichiamo l'effetto a seconda dell'immagine che viene selezionata
	     			for (Node n : listaOggetti) {
	     				if(n.getId() == imageStore.getId()) {
	     					n.setEffect(effectShadow);
	     				}
					}
	     			
	     			//imageView1.setEffect(effectShadow);
	        	}
	        } 
		};
		
		//Creiamo l'evento di selezionamento per l'ImageView1:
		EventHandler<MouseEvent> eventHandlerEntered = new EventHandler<MouseEvent>() { 
			
			 @Override 
	         public void handle(MouseEvent e) { 
				ImageView imageStore = (ImageView) e.getSource();
				 
	        	if(true) { 
	        	
	        		effectShadow.setColor(Color.BLUE);
	     			effectShadow.setBlurType(BlurType.THREE_PASS_BOX);
	     			effectShadow.setRadius(0);
	     			effectShadow.setHeight(15);
	     			effectShadow.setWidth(15);
	     			effectShadow.setSpread(10); 
	     			
	     			//Applichiamo l'effetto a seconda dell'immagine che viene selezionata
	     			for (Node n : listaOggetti) {
	     				if(n.getId() == imageStore.getId()) {
	     					n.setEffect(effectShadow);
	     				}
					}
	     			
	     			//imageView1.setEffect(effectShadow);
	        	}
	        } 
	    };
	    
	    EventHandler<MouseEvent> eventHandlerExit = new EventHandler<MouseEvent>() { 
	        
	    	@Override 
	         public void handle(MouseEvent e) {
	    		Node nodoCopy = (Node) e.getSource();
	    		
	    		ImageView imageStore = (ImageView) e.getSource();
				/*
				* System.out.println("getID -> " + imageStore.getId());
				* System.out.println("getPickResult -> " + e.getPickResult());
				* System.out.println("getStyleClass -> " + nodoCopy.getStyleClass());
				*/
	    		
	    		//Rimuoviamo l'effetto a seconda dell'immagine che viene selezionata
     			for (Node n : listaOggetti) {
     				if(n.getId() == imageStore.getId()) {
     					n.setEffect(null);
     				}
				}
	     		//imageView1.setEffect(null);
	        }
	    };
	    
	    imageView1.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandlerClicked);
	    imageView2.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandlerClicked);
	    imageView3.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandlerClicked);

	    //imageView1.addEventHandler(MouseEvent.MOUSE_EXITED, eventHandlerExit);
	    //imageView2.addEventHandler(MouseEvent.MOUSE_EXITED, eventHandlerExit);
	    //imageView3.addEventHandler(MouseEvent.MOUSE_EXITED, eventHandlerExit);
	    
		hbox.getChildren().addAll(imageView1, imageView2, imageView3);
		hbox.setSpacing(15);
		hbox_vuoto.setPrefSize(400, 400);
		hbox.setPadding(new Insets(25));
		
		vbox.getChildren().addAll(txt_testataPagina, hbox_vuoto, hbox, btn_start);
		pane_root.getChildren().addAll(vbox);
		
		/*
		 * // Oggetti istanziati per creare la classe Border(): Paint p = new Color(1,
		 * 1, 0, 0.5);
		 * 
		 * StrokeType stroke = StrokeType.CENTERED; StrokeLineJoin strokeLine =
		 * StrokeLineJoin.ROUND; StrokeLineCap strokeCap = StrokeLineCap.ROUND;
		 * BorderStrokeStyle borderStyle = new BorderStrokeStyle(stroke, strokeLine,
		 * strokeCap, 5.0, 5.0, null);
		 * 
		 * //hbox.setBorder(new Border(new BorderStroke(p, borderStyle, new
		 * CornerRadii(20), new BorderWidths(20))));
		 */		Scene scene = new Scene(pane_root, 700, 700);
		
		stage.setScene(scene);
		stage.setTitle("Home Page");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public int getArgb(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Color getColor(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PixelFormat getPixelFormat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Buffer> void getPixels(int arg0, int arg1, int arg2, int arg3, WritablePixelFormat<T> arg4,
			T arg5, int arg6) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getPixels(int arg0, int arg1, int arg2, int arg3, WritablePixelFormat<ByteBuffer> arg4, byte[] arg5,
			int arg6, int arg7) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getPixels(int arg0, int arg1, int arg2, int arg3, WritablePixelFormat<IntBuffer> arg4, int[] arg5,
			int arg6, int arg7) {
		// TODO Auto-generated method stub
		
	}

}
