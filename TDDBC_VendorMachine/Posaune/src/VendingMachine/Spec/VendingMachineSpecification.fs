module Spec.VendingMachineSpecification

open NaturalSpec

open VendingMachine

let initially vm =
    printMethod ()
    vm

let total_amount amount (vm:VendingMachine)  =
    printMethod amount 
    vm.TotalAmount = amount 

let insert_money amount (vm:VendingMachine) = 
    printMethod amount
    amount |> List.iter vm.InsertMoney
    vm
 
//Feature:お金が投入できる
[<Scenario>]
let ``After inserting 10 yen, it's total amount is 10``() =
  Given (new VendingMachine())          
    |> When insert_money [new Money(MoneyKind.Yen10)]      
    |> It should have (total_amount 10)
    |> Verify

[<Scenario>]
let ``After inserting 10 yen and 100 yen, it's total amount is 110``() =
  Given (new VendingMachine())          
    |> When insert_money [new Money(MoneyKind.Yen10);new Money(MoneyKind.Yen100)]  
    |> It should have (total_amount 110)
    |> Verify
                 
   
//Feature:投入金額の確認ができる
[<Scenario>]
let ``Initially, the total amount of this vending machine is 0``() =
  Given (new VendingMachine())                
    |> When initially      
    |> It should have (total_amount 0)
    |> Verify


//Feature:扱えないお金を管理できる
[<Scenario>]
let ``After inserting 1 yen, it's invalid so machine's total amout is 0``() =
  Given (new VendingMachine())                
    |> When insert_money [new Money(MoneyKind.Yen1)]      
    |> It should have (total_amount 0)
    |> Verify

//Feature：ジュースを購入する

let cola = new Drink();

let vending_machine_inserted_110_yen_and_have_one_drink = 
    printMethod ()
    let vm = new VendingMachine()
    vm.AddDrink(cola)
    vm.InsertMoney(new Money(MoneyKind.Yen100))
    vm.InsertMoney(new Money(MoneyKind.Yen10))
    vm
    
let buy_drink drink (vm:VendingMachine) = 
    printMethod drink
    vm.BuyDrink(drink)


[<Scenario>]
let ``After inserting 110 yen, you can buy a juice less than 110 yen``() =
    Given vending_machine_inserted_110_yen_and_have_one_drink
        |> When buy_drink cola
        |> It should equal cola 
        |> Verify

