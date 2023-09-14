const Container = ({ children }) => {
    return (
        <div style={{margin:20, padding:20, border:"1px solid gray" }}>
            {children} 
        </div>

    );
};

// children으로 컴포넌트(react.element)도 prop으로 전달될 수 있음

export default Container;