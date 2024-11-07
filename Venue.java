public class Venue {

    // define what data fields will be used to define the venue layout
    private int row;
    private int left;
    private int mid;
    private int right;
    private static final char emptySeat = '_';
    private static final char selectedSeat = 'X';
    private static final char aisle = ' ';
    private char[][] seats;
    private int currentRow = 0;
    private int currentSeat = 0;


    // define your constructors
    public Venue(){

    }
    public Venue(int row, int left, int mid, int right){
        this.row = row;
        this.left = left;
        this.mid = mid;
        this.right = right;
    }

    // write some methods to show the venue layout
    public void seatLayout(int row, int left, int mid, int right){
        for (int i =1; i<=row; i++){
            if (i == 1){
                System.out.println(" ["+"_".repeat(left)+" " + "_".repeat(mid) + " " + "_".repeat(right)+"]");
            }else{
                System.out.println("["+"_".repeat(left)+" " + "_".repeat(mid) + " " + "_".repeat(right)+"]");
            }
            
        }
    }

    public void TicketBooking(int row, int left, int mid, int right){
        seats = new char[row][left+mid+right+2];
        for (int i = 0; i< row;i++){
            for (int j =0; j<seats[i].length;j++){
                if (j==left || j==left+mid+1){
                    seats[i][j] = aisle;
                }else{
                    seats[i][j] = emptySeat;
                }
            }
        }
        seats[currentRow][currentSeat] = selectedSeat;
    }

    public void displaySeat(){
        for(char[] row:seats){
            System.out.print("[");
            for(char seat: row){
                System.out.print(seat);
            }
            System.out.println("]");
        }
    }
    public void moveSeat(char dir){
        seats[currentRow][currentSeat] = emptySeat;

        switch(dir){
            case 'w':
            case 'W':
                if (currentRow >0 && currentRow!=0){
                    currentRow--;
                    break;
                }else if (currentRow == 0){
                    System.out.println("Invalid move.");
                    break;
                }
            case 's':
            case 'S':
                if (currentRow<seats.length -1) {
                    currentRow++;
                    break;
                }else if (currentRow == seats.length-1){
                    System.out.println("Invalid move.");
                    break;
                }
            case 'a':
            case 'A':
                if (currentSeat>0 && currentSeat!=0){
                    currentSeat--;
                    break;
                }else if (currentSeat == 0){
                    System.out.println("Invalid move.");
                    break;
                }
            case 'd':
            case 'D':
                if (currentSeat < seats[currentRow].length-1 && currentSeat!=seats[currentRow].length-1){
                    currentSeat++;
                    break;
                }else if (currentSeat == seats[currentRow].length-1){
                    System.out.println("Invalid move.");
                    break;
                }
            default:
                System.out.println("Invalid input.");
                break;
        }

        if (seats[currentRow][currentSeat] == aisle){
            if (dir=='d'|| dir=='D'){
                currentSeat++;
            }else if (dir=='a' ||dir=='A'){
                currentSeat--;
            }
        }
        seats[currentRow][currentSeat] = selectedSeat;
    }
    }

