﻿using Jihanki.Cashier.Base;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace Jihanki.Controllers
{
    /// <summary>
    /// 挿入されたお金の受け入れ
    /// </summary>
    public class ReceiptMoney
    {

        #region Event

        /// <summary>
        /// 投入金の受付EVENT
        /// </summary>
        private Action<Money> _receiptEvemt;
        public event Action<Money> ReceiptEvent
        {
            add{this._receiptEvemt+=value;}
            remove { this._receiptEvemt -= value; }
        }


        #endregion







        

        /// <summary>
        /// ユーザが挿入したお金の受け入れ
        /// </summary>
        /// <param name="money">投入されたお金</param>
        /// <returns>
        /// 
        /// </returns>
        public void Receipt(Money money)
        {
            
            //登録されているユーザ投入金Event分実行
            foreach (Action<Money> n in this._receiptEvemt
                                            .GetInvocationList()
                                            .Where(s => s != null))
            {
                n(money);
            }

            
        }
    }
}
