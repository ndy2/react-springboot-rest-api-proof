import React, {useState} from "react";
import {SummaryItem} from "./SummaryItem";

export function Summary({items = []}) {

    const totalPrice = items.reduce((prev, curr) => prev + curr.price, 0);
    return (
        <React.Fragment>

            <div className="summary p-4">
                <div>
                    <h5 className="m-0 p-0"><b>Summary</b></h5>
                </div>
                {items.map(v => <SummaryItem key={v.id} menuName={v.menuName}/>)}

                <div className="row pt-2 pb-2 border-top">
                    <h5 className="col">총금액</h5>
                    <h5 className="col text-end">{totalPrice}원</h5>
                </div>
                <button className="btn btn-dark col-12">주문하기</button>
            </div>
        </React.Fragment>
    )
}