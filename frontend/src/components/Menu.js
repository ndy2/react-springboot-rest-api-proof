import React from "react";
import {Options} from "./Options";

export function Menu(props) {

    const id = props.id;
    const name = props.name;
    const price = props.price;
    const imageUrl = props.imageUrl;
    const options = props.options;
    let optionId = 1;

    const handleOptionChanged = e =>{
        optionId = e;
    }

    const handleAddBtnClick = e => {
        props.onAddClick(id, optionId);
    };

    return (
        <React.Fragment>
            <img src={imageUrl} alt="빅맥"/>
            <div> {name}</div>
            <div> {price} 원</div>
            <Options options={options} onChange={handleOptionChanged}/>
            <div className="col text-end action">
                <button onClick={handleAddBtnClick} className="btn btn-small btn-outline-dark">추가</button>
            </div>
        </React.Fragment>
    )
}