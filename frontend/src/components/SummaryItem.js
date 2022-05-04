import React, {useState} from "react";

export function SummaryItem(props) {

    const name = props.name;
    const price = props.price;
    const option = props.option;
    const optionPriceStr = option.price==null?"":"+" + option.price + "원";
    return (
        <React.Fragment>
            <div className="row">
                <h6 className="col">{name}</h6>
                <h6 className="col">{option.name}</h6>
                <h6 className="col">{price} 원</h6>
                <h6 className="col">{optionPriceStr}</h6>
            </div>
        </React.Fragment>
    )
}