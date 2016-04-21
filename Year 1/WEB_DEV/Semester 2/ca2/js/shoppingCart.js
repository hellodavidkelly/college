function calculate()
{

// declare the variables for use in the program

  QtyA = 0;  QtyB = 0;  QtyC = 0; QtyD = 0; QtyE = 0;
  TotA = 0;  TotB = 0;  TotC = 0; TotD = 0; QtyE = 0;

// declare the Prices

  PrcA = 4.99; PrcB = 8.99; PrcC = 9.99; PrcD = 4.99; PrcE = 9.99;

// ITEM A: check if user has entered a quantity in the input box
// if they have assign it to an internal variable

  if (document.getElementById("qtyA").value > "")
     	{
     	QtyA = document.getElementById("qtyA").value;
     	}

 // calculate the subtotal for Item A & display it

  TotA = eval(QtyA) * eval(PrcA);
  TotA = TotA.toFixed(2);
  document.getElementById("totalA").value = ("€") + TotA;

// ITEM B: check if user has entered a quantity in the input box
// if they have assign it to an internal variable

  if (document.getElementById("qtyB").value > "")
     {
     	QtyB = document.getElementById("qtyB").value;
     }

 // calculate the subtotal for Item B & display it

   TotB = eval(QtyB) * eval(PrcB);
   TotB = TotB.toFixed(2);
  	document.getElementById("totalB").value = ("€") + TotB;

 // ITEM C: check if user has entered a quantity in the input box
// if they have assign it to an internal variable

  if (document.getElementById("qtyC").value > "")
     {
     	QtyC = document.getElementById("qtyC").value;
     }

 // calculate the subtotal for Item C & display it

  	TotC = eval(QtyC) * eval(PrcC);
  	TotC = TotC.toFixed(2);
  	document.getElementById("totalC").value = ("€") + TotC;

// ITEM D: check if user has entered a quantity in the input box
// if they have assign it to an internal variable

  if (document.getElementById("qtyD").value > "")
     {
     	QtyD = document.getElementById("qtyD").value;
     }

 // calculate the subtotal for Item D & display it

   TotD = eval(QtyD) * eval(PrcD);
   TotD = TotD.toFixed(2);
  	document.getElementById("totalD").value = ("€") + TotD;
  	
  // ITEM E: check if user has entered a quantity in the input box
// if they have assign it to an internal variable

  if (document.getElementById("qtyE").value > "")
     {
     	QtyE = document.getElementById("qtyE").value;
     }

 // calculate the subtotal for Item E & display it

   TotE = eval(QtyE) * eval(PrcE);
   TotE = TotE.toFixed(2);
  	document.getElementById("totalE").value = ("€") + TotE;
  	
  // Keep a Running Total & display it

  Totamt = eval(TotA) + eval(TotB) + eval(TotC) + eval(TotD) + eval(TotE);
  Totamt = Totamt.toFixed(2);
  document.getElementById("GrandTotal").value = ("€") + Totamt;

	if(Totamt > "")
	{
		alert("Item has been added to shopping cart \nSelect PURCHASE when done shopping.\nCURRENT TOTAL: €" + Totamt);
	}

}

