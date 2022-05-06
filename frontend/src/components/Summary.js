import React, {useState} from "react";
import {SummaryItem} from "./SummaryItem";

export function Summary({items = [], onOrderSubmit }) {
    const totalPrice = items.reduce((prev, curr) => prev + curr.price, 0);

    const [order, setOrder] = useState({
        orderType: ""
    });

    const handleOrderTypeChanged = (e) => setOrder({...order, orderType: e.target.value})

    const handleSubmit = (e) => {
        if (order.orderType === "") {
            alert("주문 종류를 선택해 주세요 - 매장/포장")
        } else {
            onOrderSubmit()
        }
    }

    return (
        <React.Fragment>

            <div className="summary p-4">
                <div>
                    <h5 className="m-0 p-0"><b>Summary</b></h5>
                </div>

                <select name="option" onChange={handleOrderTypeChanged}>
                    <option value="">매장 or 포장</option>
                    <option value="store">매장</option>
                    <option value="takeout">포장</option>
                </select>

                {items.map(v => <SummaryItem key={v.id} {...v}/>)}

                <div className="row pt-2 pb-2 border-top">
                    <h5 className="col">총금액</h5>
                    <h5 className="col text-end">{totalPrice}원</h5>
                </div>
                <button className="btn btn-dark col-12" onClick={handleSubmit}>주문하기</button>
            </div>
        </React.Fragment>
    )
}