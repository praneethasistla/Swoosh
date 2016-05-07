package swoosh;

public class Swoosh {

    public static void drawSwoosh(int width) {

        /*
    Divide the area into 4 quarters.
    Each quarter would have different properties filled by "x" and "-"
    These proportions are found by divinding the area into grid level
         */
        int height = width / 2;
        int frac = (3 * width) / 16;
        /*
    First quarter: (top-left)
        Print x except for when you are in the region of 
        height/4 and 3/16 of width. However this fraction of width
        changes as height changes. Therefore divide by i+1.
        These numbers are achieved by calculating the fraction of 
        the region that the "-" need to appear.
        Height wise: the "-" appear in the first quarter of height
        Width wise: the "-" appear in the 3/8th region of the half
                    In addition, it changes when you go to the next 
                    row. Therefore, divide by i+1 to avoid division by
                    zero error.
         */
        for (int i = 0; i < height / 2; i++) {
            for (int j = 0; j < width / 2; j++) {
                if (i < height / 4 && j < (frac / (i + 1))) {
                    System.out.print("- ");
                } else {
                    System.out.print("x ");
                }
            } //end of first quarter

            /*
        Second quarter: (top-right)
            Print "x" except when you are in the following two regions:
            The area similar to the first quarter which is formed by 
            height/4 and 3/16th width changed by i+1.
            The second region is in the area formed by 3/8th of height
            and the last quarter of the width. 
             */
            for (int j = width / 2; j > 0; j--) {
                if ((i < height / 4 && j <= (frac / (i + 1)))
                        || ((i >= (3 * height) / 8) && (j <= width / 4))) {
                    System.out.print("- ");
                } else {
                    System.out.print("x ");
                }
            } //end of second quarter
            System.out.println("");
        }

        /*
    Third quarter:
        This quarter is divided into two halves vertically.
        The first half is similar to what happened with the
        first two quarters above.
    
        We start i from height/2 and countdown to 0.
        Print x except when in the region created by
        the last quarter of the height and 3/16th of width
        divided by i. We can do i here instead of i+1 
        since there is no zero error. Instead add 1 to 
        the height portion of area.
         */
        for (int i = height / 2; i > 0; i--) {
            for (int j = 0; j < width / 4; j++) {
                if (i <= ((height) / 8) + 1 && j < (frac / (i))) {
                    System.out.print("- ");
                } else {
                    System.out.print("x ");
                }
            } //end of third quarter first half

            /*
        Third quarter second half:
        The areas to fill "-" is calculated by breaking down into grid level.
        the regions of the grid are then calculated as proportions of height and width
        then those areas are inputted
            Fill with "x" in these areas:
            1. When in the 3/8th area of the width
            2. In the swoosh, you are in the lower 1/8th area of the height
            3. In the swoosh, you are in the area between 3/8th and half of the height
            4. lastly, if you are in the area formed by 1/8th and 1/4 of the lower swoosh height
                and 7/16th of the width.
        the rest is filled by "-"
             */
            for (int j = width / 4; j < width / 2; j++) {
                if ((j < ((3 * width) / 8))
                        || (i > (3 * height) / 8) || (i <= ((height) / 8))
                        || (i > (height) / 8 && i <= (height) / 4 && (j < (7 * width) / 16))) {
                    System.out.print("x ");
                } else {
                    System.out.print("- ");
                }
            }//end of 3rd quarter second half

            /*
        Fourth quarter:
            This is completely filled by "-"
             */
            for (int j = width / 2; j < width; j++) {
                System.out.print("- ");
            } //end of fourth quarter
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        drawSwoosh(24);
    }
}
