## Overview

Create a cash register that should be able to accept only $20, $10, $5, $2 and $1 bills. Given the charge and amount of money received return the change in each denomination that should be given from the cash register. 

* The start file is HelloChange.java to for a command line interaction
* Tests are also implemented


## Example

```
// start program, waiting for command
ready
// show current state in total and each denomination:
// $Total $20 $10 $5 $2 $1
// for example $68 1 2 3 4 5 means:
// Total=$68 $20x1 $10x2 $5x3 $2x4 $1x5
> show
$68 1 2 3 4 5
// put bills in each denomination: $20 $10 $5 $2 $1
// show current state
> put 1 2 3 0 5
$128 2 4 6 4 10
// take bills in each denomination: $20 $10 $5 $2 $1
// show current state
> take 1 4 3 0 10
$43 1 0 3 4 0
// given amount
// show change in each denomination: $20 $10 $5 $2 $1
// show change but do not remove it from cash register
> change 11
0 0 1 3 0
> show
$32 1 0 2 1 0
// show error if there is insufficient funds or no change can't be made
> change 14
sorry, insufficient amount in register
// exit program
> quit
Bye
```