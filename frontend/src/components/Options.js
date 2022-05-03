import React, {useState} from "react";

export function Options({options}) {
    if (options.length === 0) return (
        <></>
    )

    return (
        <React.Fragment>
            <select name="option">
                <option value="">옵션선택</option>

                {options.map(v =>
                    <option value="1">{v.name} +{v.price}원</option>
                )}

            </select>
        </React.Fragment>
    )
}