/*	Author: Phillip Pham
 * 	Date: 03/23/17
 * 	Course: CSC230	Section: 18043
 * 	
 * 	Program Title: Hardware Multiply
 * 	Program Description: This program is meant to simulate how a machine actually multiplies efficiently without
 * 				just using a single loop that calculates the sum over and over again. It simulates having
 * 				two 32-bit numbers being multiplied and stored as a 64-bit number.
 * 
 * 	Algorithm:	1.) The first step is to first set the multiplicand and the multiplier to their respective values
 * 				chosen by the user, which is passed into the constructor.
 * 				2.) The initial product needs to be set to zero, and if the multiplier or multiplicands are
 * 				set to zero, nothing is calculated because the answer is obviously zero.
 * 				3.) If neither of them are zero, then it goes into a FOR loop which will iterate until the 
 * 				iterator is equal to the number of bits that are in the multiplier.
 * 				4.) The multiplier is AND'ed with a 1 in the left-most bit, and if the answer is not zero,
 * 				it will do calculations. If equal to zero, only the product and multiplier are shifted to the 
 * 				right by 1-bit.
 * 				5.) A temp Long variable called leftHalf is created in order to simulate the left-most
 * 				32-bit register in the 64-bit product.
 * 				6.) The multiplicand is added to leftHalf, and then leftHalf is shifted to the left 32-bits.
 * 				7.) leftHalf is then added to the product, and then the product and multiplier is shifted to
 * 				the right by 1 bit.
 * 				8.) The loop continues until the iterator has become equal to the number of bits in the multiplier.
 * 				9.) To retrieve the answer, you will need to use the getProduct() method.
 */

public class Multiply
{
	// Attributes
	private Integer multiplicand, multiplier;
	private Long product;
	
	// Constructor
	public Multiply(int multiplicand, int multiplier)
	{
		this.multiplicand = multiplicand;
		this.multiplier = multiplier;
		calculate();
	}
	
	private Long calculate()
	{
		// This will set the product's initial value to 0
		this.product = 0L;
		
		// Checks if the multiplier is zero before starting, because the answer would obviously be zero
		if(this.multiplier != 0 && this.multiplicand != 0)
		{
			// This loop will loop as many times as there are bits in the multiplier
			for (int i = 0; i < this.multiplier.SIZE; ++i)
			{
				// This will be to initialize the first half of the product
				Long leftHalf = 0L;
				
				// Checks if the bit at the multiplier is zero, if not it continues calculation
				if((this.multiplier & 1) != 0)
				{
					// This will convert the multiplicand to a Long value by shifting it 32-bits to the left
					// This will give us our first half of the 64-bit register
					leftHalf = (leftHalf + this.multiplicand) << 32;
					
					// And then we add the left half to the 64-bit product register, 
					// in this case represented by a Long called product
					this.product += leftHalf;
				}
				
				// This will shift our product and multiplier to the right by 1 bit after every iteration
				this.product = this.product >> 1;
				this.multiplier = this.multiplier >> 1;
			}
			
			return this.product;
		}
		else
		{
			return this.product;
		}
	}
	
	// Getter
	public long getProduct()
	{
		return this.product;
	}
}