package RusHourG5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serial;

public class MainWindow extends JPanel implements ActionListener,MouseListener{



	/**
	 * This class represents the main window of the game. It implements ActionListener, MouseListener, and KeyListener interfaces.
	 * It has instance variables to store information about the game's level, position of objects, and various UI elements.
	 *
	 * The constructor takes an integer parameter that represents the game level, and initializes the instance variables by calling helper methods such as getMap() and getIcons().
	 * It also sets the layout of the game window to null and sets the size to 600x600.
	 *
	 * There is a method called initialize() that initializes the game board by creating Car objects and adding them to the game window.
	 * There is also a nested class called MapU that has a method called getMap() that returns an array of Attribute objects representing the game board.
	 *
	 * The class also has a MouseAdapter object called "restart" with a mouseClicked() method that restarts the game by resetting the step count,
	 * removing all cars from the game window, and calling the initialize() method again.
	 *
	 * Overall, this class manages the game window and its components such as the game board and restart button, and responds to user input and events such as mouse clicks and key presses.
	 */
	@Serial
	private static final long serialVersionUID = 1L;

	int leftX=60,leftY=60;
	int level,W=100;
	int step = 0;
	int elements;
	Icon[] icons;
	Image[] pictures;
	Attribute[] map;
	Car[] cars;
	Point pointStart = new Point(0,0);
	Point pointEnd = new Point(0,0);
	Rectangle leftB = new Rectangle(leftX-10, leftY, 10, 6*W);
	Rectangle rightB = new Rectangle(leftX+6*W, leftY, 10, 6*W);
	Rectangle upB = new Rectangle(leftX, leftY-10, 6*W, 10);
	Rectangle downB = new Rectangle(leftX, leftY+6*W, 6*W, 10);

	public static final int UP=1,DOWN=2,LEFT=3,RIGHT=4;

	MapU mapU = new MapU();

	public MainWindow(int level) {

		//Map BackGround





        this.level = level;
        map = mapU.getMap(level);
        elements = MapLibrary.getElementsNumberInMap(level);
        cars = new Car[13];
        icons = new Icon[23];
        pictures = new Image[23];
        setLayout(null);
        setSize(600, 600);
        getIcons();
        initialize();
        
        AddtionFunc.restart.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                step = 0;
                for (int i = 0; i < elements; i++) {
                    GameRealize.mainWindow.remove(cars[i]);
                }
                repaint();
                map = mapU.getMap(level);
                GameRealize.panel.remove(GameRealize.addtionFunc);
                GameRealize.addtionFunc = new AddtionFunc(level);
                GameRealize.panel.add(GameRealize.addtionFunc, BorderLayout.EAST);
                GameRealize.addtionFunc.validate();
                GameRealize.mainWindow.validate();
                GameRealize.panel.validate();
                initialize();
                setVisible(true);
                GameRealize.mainWindow.requestFocus();
                repaint();
            }
        });
    }

	/**
	 * This method paints the game window by clearing the graphics context and then painting all car objects on the screen.
	 * It sets the layout to null and calls the super method paintComponent() to draw the game components on the screen.
	 *
	 * The getIcons() method loads the game images and stores them as icons and images in instance variables.
	 * The selectDimension() method returns the appropriate dimensions for each image based on its index.
	 * The getResizedImage() method loads each image from the image directory and scales it to the appropriate size using the getScaledInstance() method.
	 */
	public void paint(Graphics g){
		setLayout(null);
		super.paintComponent(g);
		g.clearRect(0, 0, getWidth(), getHeight());
		for(int i=0;i<elements;i++){
			cars[i].requestFocus();
			cars[i].paintComponents(g);
		}
	}
	
	
	//获取图片
	private void getIcons() {
	    for (int i = 0; i < 23; i++) {
	        Dimension size = selectDimension(i);
	        pictures[i] = getResizedImage(i, size);
	        icons[i] = new ImageIcon(pictures[i]);
	    }
	    repaint();
	}

	private Dimension selectDimension(int i) {
	    if (i >= 0 && i <=6) {
	    		return new Dimension(2*W, W);
	    } 
	    else if (i >= 7 && i <= 10) {
	        return new Dimension(W, 3*W);
	    } else if (i >= 11 && i<=19) {
	        return new Dimension(W,2*W);
	    } else if (i >=20 && i<=22){
	        return new Dimension(3*W, W);
	    }
	    else
	    	return new Dimension(10*W,10*W);
	}

	private Image getResizedImage(int index, Dimension size) {
	    return Toolkit.getDefaultToolkit().getImage("src/imageBag/rushourImage/pic" + index + ".png")
	        .getScaledInstance(size.width, size.height, Image.SCALE_SMOOTH);
	}



	/**

	 This method initializes the cars and their properties based on the provided map data.
	 It assigns icons, bounds, and event listeners to each car object.
	 The initialization process follows the rules defined by the map data and sets up the cars accordingly.
	 The cars are represented by objects of the {@link Car} class.
	 Note: This method assumes that the necessary icons and map data have been properly set up beforehand.
	 @see Car
	 */
	private void initialize() {
		for(int i=0;i<elements;i++){
			switch (map[i].getId()) {
				case 0 -> {
					cars[i] = new Car(0, "BrownCar");
					if (map[i].getDirection()) {//横
						cars[i].setIcon(icons[0]);
						cars[i].setBounds(leftX + map[i].getY() * W, leftY + map[i].getX() * W, 2 * W, W);
					} else {//竖
						cars[i].setIcon(icons[11]);
						cars[i].setBounds(leftX + map[i].getY() * W, leftY + map[i].getX() * W, W, 2 * W);
					}
				}
				case 1 -> {
					cars[i] = new Car(1, "YelloCar");
					cars[i].setIcon(icons[1]);
					cars[i].setBounds(leftX + map[i].getY() * W, leftY + map[i].getX() * W, 2 * W, W);
				}
				case 2 -> {
					cars[i] = new Car(2, "GreenCar");
					if (map[i].getDirection()) {//横放
						cars[i].setIcon(icons[2]);
						cars[i].setBounds(leftX + map[i].getY() * W, leftY + map[i].getX() * W, 2 * W, W);
					} else {//竖放
						cars[i].setIcon(icons[12]);
						cars[i].setBounds(leftX + map[i].getY() * W, leftY + map[i].getX() * W, W, 2 * W);
					}
				}
				case 3 -> {
					cars[i] = new Car(3, "BlueCar");
					if (map[i].getDirection()) {//横放
						cars[i].setIcon(icons[3]);
						cars[i].setBounds(leftX + map[i].getY() * W, leftY + map[i].getX() * W, 2 * W, W);
					} else {//竖放
						cars[i].setIcon(icons[13]);
						cars[i].setBounds(leftX + map[i].getY() * W, leftY + map[i].getX() * W, W, 2 * W);
					}
				}
				case 4 -> {
					cars[i] = new Car(4, "GrayCar");
					if (map[i].getDirection()) {//横放
						cars[i].setIcon(icons[4]);
						cars[i].setBounds(leftX + map[i].getY() * W, leftY + map[i].getX() * W, 2 * W, W);
					} else {//竖放
						cars[i].setIcon(icons[14]);
						cars[i].setBounds(leftX + map[i].getY() * W, leftY + map[i].getX() * W, W, 2 * W);
					}
				}
				case 5 -> {
					cars[i] = new Car(5, "PurpleCar");
					if (map[i].getDirection()) {//横放
						cars[i].setIcon(icons[5]);
						cars[i].setBounds(leftX + map[i].getY() * W, leftY + map[i].getX() * W, 2 * W, W);
					} else {//竖放
						cars[i].setIcon(icons[15]);
						cars[i].setBounds(leftX + map[i].getY() * W, leftY + map[i].getX() * W, W, 2 * W);
					}
				}
				case 6 -> {
					cars[i] = new Car(6, "DarkPurple");
					if (map[i].getDirection()) {
						cars[i].setIcon(icons[6]);
						cars[i].setBounds(leftX + map[i].getY() * W, leftY + map[i].getX() * W, 2 * W, W);
					} else {
						cars[i].setIcon(icons[16]);
						cars[i].setBounds(leftX + map[i].getY() * W, leftY + map[i].getX() * W, W, 2 * W);
					}
				}
				case 7 -> {
					cars[i] = new Car(7, "BigGray");
					if (map[i].getDirection()) {
						cars[i].setIcon(icons[20]);
						cars[i].setBounds(leftX + map[i].getY() * W, leftY + map[i].getX() * W, 3 * W, W);
					} else {
						cars[i].setIcon(icons[7]);
						cars[i].setBounds(leftX + map[i].getY() * W, leftY + map[i].getX() * W, W, 3 * W);
					}
				}
				case 8 -> {
					cars[i] = new Car(8, "BigRed");
					if (map[i].getDirection()) {
						cars[i].setIcon(icons[21]);
						cars[i].setBounds(leftX + map[i].getY() * W, leftY + map[i].getX() * W, 3 * W, W);
					} else {
						cars[i].setIcon(icons[8]);
						cars[i].setBounds(leftX + map[i].getY() * W, leftY + map[i].getX() * W, W, 3 * W);
					}
				}
				case 9 -> {
					cars[i] = new Car(9, "BigPurple");
					cars[i].setIcon(icons[9]);
					cars[i].setBounds(leftX + map[i].getY() * W, leftY + map[i].getX() * W, W, 3 * W);
				}
				case 10 -> {
					cars[i] = new Car(10, "BigBlue");
					if (map[i].getDirection()) {
						cars[i].setIcon(icons[22]);
						cars[i].setBounds(leftX + map[i].getY() * W, leftY + map[i].getX() * W, 3 * W, W);
					} else {
						cars[i].setIcon(icons[10]);
						cars[i].setBounds(leftX + map[i].getY() * W, leftY + map[i].getX() * W, W, 3 * W);
					}
				}
				case 11 -> {
					cars[i] = new Car(11, "Darkblue");
					cars[i].setIcon(icons[11]);
					cars[i].setBounds(leftX + map[i].getY() * W, leftY + map[i].getX() * W, W, 2 * W);
				}
				case 12 -> {
					cars[i] = new Car(12, "RedCar");
					if (map[i].getDirection()) {
						cars[i].setIcon(icons[19]);
						cars[i].setBounds(leftX + map[i].getY() * W, leftY + map[i].getX() * W, 2 * W, W);
					} else {
						cars[i].setIcon(icons[19]);
						cars[i].setBounds(leftX + map[i].getY() * W, leftY + map[i].getX() * W, W, 2 * W);
					}
				}
			}
			cars[i].addMouseListener(this);
//			cars[i].addKeyListener(this);
			this.add(cars[i]);
//			cars[i].setContentAreaFilled(false);
		    cars[i].setBackground(Color.WHITE);
			cars[i].setBorderPainted(true);
			cars[i].setFocusPainted(true);
		}	
	}
	/**
	 * This method calculates the direction of a mouse gesture and returns a string indicating the direction of the gesture.
	 * If the gesture indicates no movement, the method returns "no move".
	 *
	 * The mousePressed() method is called when a mouse button is pressed on a Car object and sets the start point of the gesture.
	 * The mouseReleased() method is called when the mouse button is released and determines the direction of the gesture based on the start and end points.
	 * Depending on the direction of the gesture, the method checks if the car can move in that direction using the getCanMoveFlag() method,
	 * and if the car can move, it calls the move() method to update its position on the game board.
	 *
	 * Overall, these methods handle user input and event processing related to moving cars on the game board.
	 */
	private String getDirection(){
		int dx,dy;
		String direction;
		dx = pointEnd.x - pointStart.x;
		dy = pointEnd.y - pointStart.y;
		if(dx==0&&dy==0){
			return "no move";
		}
		if(Math.abs(dx)>Math.abs(dy)){//水平方向的偏移大于竖直方向的偏移，即水平方向运动
			if(dx>0){//释放点在按压点右边
				direction =  "rightB";
			}else{
				direction =  "leftB";				
			}
			
		}else{//竖直方向的偏移大于水平方向的偏移，即竖直方向运动
			if(dy>0){//释放点在按压点下边
				direction =  "down";
			}else{
				direction =  "up";				
			}
			
		}
		return direction;
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource()==null)//没有选中任何按钮，直接返回
			return ;
		pointStart.x = e.getX();
		pointStart.y = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource()==null)
			return ;
		Car vehicle = (Car) e.getSource();
		pointEnd.x = e.getX();
		pointEnd.y = e.getY();
		String direction = getDirection();
		boolean ifMove;
		if(direction.equals("up")&&(vehicle.getHeight()>vehicle.getWidth())){
			ifMove = getCanMoveFlag(vehicle,UP);
			if(ifMove)
				move(vehicle,UP);
			
		}else if(direction.equals("down")&&(vehicle.getHeight()>vehicle.getWidth())){ 
			ifMove = getCanMoveFlag(vehicle,DOWN);
			if(ifMove)
				move(vehicle,DOWN);			
		}else if(direction.equals("leftB")&&(vehicle.getHeight()<vehicle.getWidth())){
			ifMove = getCanMoveFlag(vehicle,LEFT);
			if(ifMove)
				move(vehicle,LEFT);
		}else if(direction.equals("rightB")&&(vehicle.getHeight()<vehicle.getWidth())){
			ifMove = getCanMoveFlag(vehicle,RIGHT);
			if(ifMove)
				move(vehicle,RIGHT);			
		}
	}


	/**
	 * Initializes the cars on the game board based on the map data.
	 * Sets icons, positions, and event listeners for each car.
	 */
	private void move(Car vehicle, int direction) {
		switch (direction) {
			case UP -> vehicle.setLocation(vehicle.getX(), vehicle.getY() - W);
			case DOWN -> vehicle.setLocation(vehicle.getX(), vehicle.getY() + W);
			case LEFT -> vehicle.setLocation(vehicle.getX() - W, vehicle.getY());
			case RIGHT -> vehicle.setLocation(vehicle.getX() + W, vehicle.getY());
		}
		/*
		  Moves the specified vehicle in the given direction.

		  @param vehicle The car object to move.
		 * @param direction The direction to move the vehicle in.
		 *                  Valid values are: {@code UP}, {@code DOWN}, {@code LEFT}, {@code RIGHT}.
		 *                  Any other value will have no effect on the vehicle's movement.
		 */

		step++;
		AddtionFunc.nowStep.setText(""+step);
		if(isWin(vehicle)){
			if(level==10){JOptionPane.showMessageDialog(this, "Congratulations on passing the final test");}
			else{	
				String msg;
				if(step<mapU.getRecord(level)){
					msg = "Congratulations！Pass Level:"+level+"！！！\nSteps:"+step+"\nRecord"+mapU.getRecord(level)+"\nNext Level？";
					mapU.updateRecode(level, step);
				}else{
					msg = "Congratulations！Pass Level:"+level+"！！！\nSteps"+step+"\n"+"Next Level？";
				}
				int type = JOptionPane.YES_NO_OPTION;
				String title = "Pass!";
				int choice;
				choice = JOptionPane.showConfirmDialog(null, msg,title,type);
				if(choice==1){
					System.exit(0);
				}else if(choice == 0){
					level++;
					step = 0;
					for(int i=0;i<elements;i++){
						this.remove(cars[i]);
					}
					repaint();
					map = mapU.getMap(level);
					GameRealize.panel.remove(GameRealize.addtionFunc);
					GameRealize.addtionFunc = new AddtionFunc(level);
					GameRealize.panel.add(GameRealize.addtionFunc,BorderLayout.EAST);
					GameRealize.addtionFunc.validate();
					GameRealize.mainWindow.validate();
					GameRealize.panel.validate();
					initialize();
					setVisible(true);
					this.requestFocus();
					AddtionFunc.restart.removeMouseListener(this);
					AddtionFunc.restart.addMouseListener(new MouseAdapter(){
						public void mouseClicked(MouseEvent e){
							step = 0;
							for(int i=0;i<elements;i++){
								GameRealize.mainWindow.remove(cars[i]);
							}
							repaint();
							map = mapU.getMap(level);
							GameRealize.panel.remove(GameRealize.addtionFunc);
							GameRealize.addtionFunc = new AddtionFunc(level);
							GameRealize.panel.add(GameRealize.addtionFunc,BorderLayout.EAST);
							GameRealize.addtionFunc.validate();
							GameRealize.mainWindow.validate();
							GameRealize.panel.validate();
							initialize();
							setVisible(true);
							GameRealize.mainWindow.requestFocus();
							repaint();
						}
					});
				}
			}
		}
	}

	
	private boolean isWin(Car vehicle) {
		return vehicle.getId() == 1 && vehicle.getX() == leftX + 4 * W && vehicle.getY() == leftY + 2 * W;
	}

	private boolean getCanMoveFlag(Car vehicle, int direction) {

		boolean ifMove = true;
		Rectangle vehicleRect = vehicle.getBounds();//Returns the rectangular object corresponding to the clicked person button


		int x = vehicleRect.x;
		int y = vehicleRect.y;		
		if(direction ==UP){
			y -= W;
		}else if(direction == DOWN){
			y += W;
		}else if(direction == LEFT){
			x -= W;
		}else if(direction == RIGHT){
			x += W;
		}
		vehicleRect.setLocation(x, y);//The rectangle has been moved
		for(int i=0;i<elements;i++){
			if(cars[i].getId()!=vehicle.getId()){//Collision detection is carried out between the rectangle after displacement and the rectangle corresponding to other figure blocks
				Rectangle personRect = cars[i].getBounds();
				if(personRect.intersects(vehicleRect)){//If two rectangles intersect, they cannot be moved
					ifMove = false;
				}
			}
		}
		
		//Detect if it is outside the play area
		if(vehicleRect.intersects(upB)||vehicleRect.intersects(downB)||vehicleRect.intersects(leftB)||vehicleRect.intersects(rightB)){
			ifMove = false;
		}
		
		
		return ifMove;
	}

	/**
	 * Handles the key press event. Allows navigation between levels using the A and D keys.
	 *
	 */

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
