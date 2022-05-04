import React, {useState} from "react";

export function Options(props) {

    const options = props.options;
    const handleOptionChanged = props.onChange;

    if (options.length === 0) return (
        <></>
    )

    const onOptionChange = e => {
        handleOptionChanged(e.target.value);
    };

    return (
        <React.Fragment>
            <select name="option" onChange={onOptionChange}>
                <option value="">옵션선택</option>

                {options.map(v =>
                    <option key={v.id} value={v.id}>{v.name} +{v.price}원</option>
                )}

            </select>
        </React.Fragment>
    )
}